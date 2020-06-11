package org.fisco.bcos.controllers;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.beans.ContractAddr;
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
public class IndexController {
    @Autowired
    ContractAddr contractAddr;
    @Autowired
    Web3j web3j;
    @Autowired
    Credentials credentials;
    @Autowired
    HttpServletRequest request;

    static Integer CODENUM = 6;
    @RequestMapping("/")
    public String login(){
        return "login.html";
    }
    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }
    @RequestMapping(value = "/send_check_code")
    @ResponseBody
    public String sendCheckCode(@RequestParam("phone") String phone){
        String code = SendMessageUtil.getRandomCode(CODENUM);
        HttpSession session = request.getSession();
        session.setAttribute("phoneNum",phone);
        session.setAttribute("checkCode", code);
        session.setAttribute("sendCodeTime", new Date().getTime());
        Integer i = SendMessageUtil.sendCode(code,phone);
        String message = SendMessageUtil.getMessage(i);
        System.out.println(message);
        System.out.println(message);
        System.out.println(message);
        return "success";
    }
    @RequestMapping(value = "/checkCode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String checkCode(@RequestBody JSONObject jsonObject){
        //check code
        String code = (String)request.getSession().getAttribute("checkCode");
        System.out.println("the correct code is "+ code);
        System.out.println("----------get input code ----------");
        System.out.println(jsonObject.get("inputCode").toString());
        System.out.println("----------end input code------------");
//        System.out.println("-----get input json -------------");
//        System.out.println(jsonObject.toJSONString());
//        System.out.println("----------end-----------");
        String inputCode = (String)jsonObject.get("inputCode");
        request.getSession().setAttribute("name",(String)jsonObject.get("name"));
//        if(code.equals(inputCode)) {
            JSONObject ret = new JSONObject();
            ret.put("status","success");
            System.out.println("successfully return: "+ ret.toJSONString());
            return ret.toJSONString();//}
//        else {
//            JSONObject ret = new JSONObject();
//            ret.put("status","fail");
//            return ret.toJSONString();
//        }
    }
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signUp(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        String username = (String) request.getSession().getAttribute("name");
        KeyUtil.UserKey key = KeyUtil.createUserKey();
        ret.put("status", "ok");
        ret.put("public_key", key.getPublicKey());
        ret.put("address", key.getAddress());
        ret.put("private_key", key.getPrivateKey());
        Credentials credentials = GenCredential.create(key.getPrivateKey());
        AccountContractClient accountContractClient = new AccountContractClient(credentials,contractAddr.getAccountContractAddress(),web3j);
        request.getSession().setAttribute("account_contract_client", new AccountContractClient(credentials,contractAddr.getAccountContractAddress(),web3j));
        accountContractClient.addAccount(username);
        return  ret.toJSONString();
    }
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String signIn(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        String privateKey = (String)jsonObject.get("private_key");
        Credentials inputCredentials = GenCredential.create(privateKey);
        //check credentials
        String publicKey1 = KeyUtil.getPublicKey(privateKey);
        String publicKey2 = (String)jsonObject.get("public_key");
        if(publicKey1.equals(publicKey2)) {
            request.getSession().setAttribute("credentials", inputCredentials);
            request.getSession().setAttribute("account_contract_client", new AccountContractClient(inputCredentials, contractAddr.getAccountContractAddress(), web3j));
            request.getSession().setAttribute("market_contract_client", new MarketContractClient(inputCredentials, contractAddr.getMarketContractAddress(), web3j));
            request.getSession().setAttribute("cop_contract_client", new CopyrightContractClient(inputCredentials, contractAddr.getCopyrightContractAddress(), web3j));
            request.getSession().setAttribute("transaction_contract_client", new TransactionContractClient(inputCredentials, contractAddr.getTransactionContractAddress(), web3j));
            ret.put("status", "ok");
        }
        else{
            ret.put("status","error");
        }
        return ret.toJSONString();

    }
    @Configuration
    public class htmlController  extends WebMvcConfigurerAdapter {
        @Override
        public void addViewControllers( ViewControllerRegistry registry ) {
            registry.addViewController( "/" ).setViewName( "forward:/login.html" );
            registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
            super.addViewControllers( registry );
        }
    }
    @RequestMapping(value = "/get_index_user_name", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getIndexUserName(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("account_contract_client");
        if(clientObj == null){
            System.out.println("Please sign in first");
            ret.put("status", "error");
            ret.put("error_type", "client_null");
        }
        AccountContractClient client = (AccountContractClient) clientObj;
        AccountInfo accountInfo = client.getAccountInfo();
        if(accountInfo==null){
            ret.put("status", "error");
            ret.put("error_type", "info_null");
            return ret.toJSONString();
        }
        ret.put("status", "ok");
        ret.put("info", accountInfo);
        return ret.toJSONString();
    }

//    @RequestMapping(value = "/test_front", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public String testFront(@RequestBody JSONObject jsonObject){
//        JSONObject ret = new JSONObject();
//        ret.put("status","ok");
//        String message = (String) jsonObject.get("testMessage");
//        ret.put("Message",message);
//        System.out.println("The Message is"+ message);
//        System.out.println("The Message is"+ message);
//        System.out.println("The Message is"+ message);
//        System.out.println("The Message is"+ message);
//        System.out.println("The Message is"+ message);
//        System.out.println("The Message is"+ message);
//        return ret.toJSONString();
//
//    }
//    @RequestMapping(value="/test_mvc")
//    public String testMVC(){
//        String Message = "HHHH";
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        System.out.println(Message);
//        return "about-us.html";
//    }


}
