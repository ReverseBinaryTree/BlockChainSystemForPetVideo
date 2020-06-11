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
public class AccountController {
    @Autowired
    HttpServletRequest request;
    @RequestMapping(value = "/get_account_info", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAccountInfo(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("account_contract_client");
        //未登录
        if(clientObj == null){
            ret.put("status", "error");
            ret.put("error_type", "client_null");
            return ret.toJSONString();
        }
        AccountContractClient client = (AccountContractClient) clientObj;
        AccountInfo info = client.getAccountInfo();
        //无法获取用户信息
        if(info == null){
            ret.put("status", "error");
            ret.put("error_type", "info_null");
            return ret.toJSONString();
        }
        System.out.println("---------------AccountInfo successfully return--------------");
        ret.put("status", "ok");
        ret.put("info", info);
        return ret.toJSONString();
    }

}
