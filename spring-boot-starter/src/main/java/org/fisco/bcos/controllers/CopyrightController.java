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
import java.util.ArrayList;
import java.util.Date;


@Controller
public class CopyrightController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/get_copyright_info", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCopyrightInfo(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("cop_contract_client");
        //未登录
        if(clientObj == null){
            ret.put("status", "error");
            ret.put("error_type", "client_null");
            return ret.toJSONString();
        }
        CopyrightContractClient client = (CopyrightContractClient)clientObj;
        String copId = (String)jsonObject.get("cop_id");
        //缺少cop_id参数
        if(copId == null){
            ret.put("status","error");
            ret.put("error_type", "lack_cop_id");
            return ret.toJSONString();
        }
        CopyrightInfo info = client.getCopyrightInfo(copId);
        //获取信息失败
        if(info == null){
            ret.put("status", "error");
            ret.put("error", "info_null");
            return ret.toJSONString();
        }
        ret.put("status", "ok");
        ret.put("info", info);
        System.out.println("-----------get_copyright_info---------------");
        System.out.println(info.toString());
        return ret.toJSONString();
    }
    @RequestMapping(value = "/set_copyright_price", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String setCopyrightPrice(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("cop_contract_client");
        //未登录
        if(clientObj == null){
            ret.put("error_type", "client_null");
            ret.put("status", "error");
            return ret.toJSONString();
        }
        CopyrightContractClient client = (CopyrightContractClient)clientObj;
        String copId = (String)jsonObject.get("cop_id");
        String price = (String)jsonObject.get("price");
        client.setCopyrightPrice(copId, price);
        ret.put("status", "ok");
        return ret.toJSONString();
    }
}
