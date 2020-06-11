package org.fisco.bcos.controllers;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.beans.ContractAddr;
import org.fisco.bcos.beans.CopyrightInfo;
import org.fisco.bcos.clients.*;
import org.fisco.bcos.util.KeyUtil;
import org.fisco.bcos.util.PhoneDB;
import org.fisco.bcos.util.SendMessageUtil;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MarketController {

    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/recharge", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String recharge(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        String amount = (String)jsonObject.get("amount");
        client.recharge(amount);
        ret.put("status", "ok");
        return ret.toJSONString();
    }
    @RequestMapping(value = "/upload_copyright", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String uploadCopyright(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        String tag = (String) jsonObject.get("tag");
        String hash = (String) jsonObject.get("hash");
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        Credentials userCredentials = (Credentials) request.getSession().getAttribute("credentials");
        CopyrightInfo info = client.creatCopyrightAndGiveTo(userCredentials.getAddress(),tag,hash);
        ret.put("status","ok");
        System.out.println("--------------new copyright---------");
        System.out.println("address: "+ info.getCopyrightId());
        return ret.toJSONString();
    }

    @RequestMapping(value = "/pull_copyright", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String pullCopyright(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        String copId=(String)jsonObject.get("cop_id");
        System.out.println("copId is: "+copId);
        client.pullCopyright(copId);
        ret.put("status","ok");
        return ret.toJSONString();
    }
    @RequestMapping(value = "/push_copyright", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String pushCopyright(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        Object copClientObj = request.getSession().getAttribute("cop_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        CopyrightContractClient copClient= (CopyrightContractClient) copClientObj;
        String copId=(String)jsonObject.get("cop_id");
        String price=(String) jsonObject.get("price");
        //check same tag
        List<String> addrs= client.getCopyrightsOnSale();
        CopyrightInfo inputInfo = copClient.getCopyrightInfo(copId);
        for(String addr:addrs){
            CopyrightInfo copInfo = copClient.getCopyrightInfo(addr);
            if(copInfo.getTag().equals(inputInfo.getTag())){
                ret.put("status","same_tag");
                return ret.toJSONString();
            }
        }
        System.out.println("copId is: "+copId);
        System.out.println("!!!!!!!!!!!!!!!price string: " + price);
        System.out.println("!!!!!!!!!jsongo"+jsonObject.toJSONString());
        client.pushCopyright(copId,new BigInteger(price.trim()));
        ret.put("status","ok");
        return ret.toJSONString();
    }

//{status: "ok", copyrights_on_sale: [{...}, {...}, {...},....]}
    @RequestMapping(value = "/get_copyrights_on_sale", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCopyrightsOnSale(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        Object copyrightsClientObj = request.getSession().getAttribute("cop_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        CopyrightContractClient copyrightsClient = (CopyrightContractClient)copyrightsClientObj;
        ret.put("status", "ok");
        List<String> addrs = client.getCopyrightsOnSale();
        List<CopyrightInfo>copyrights = new ArrayList<>();
        for(String addr : addrs){
            copyrights.add(copyrightsClient.getCopyrightInfo(addr));
        }
        ret.put("copyrights_on_sale", copyrights);
        return ret.toJSONString();
    }
    @RequestMapping(value = "/buy_copyright", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String buyCopyright(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("market_contract_client");
        MarketContractClient client = (MarketContractClient)clientObj;
        String copId=(String)jsonObject.get("cop_id");
        client.buyCopyright(copId);
        ret.put("status","ok");
        return ret.toJSONString();
    }


}
