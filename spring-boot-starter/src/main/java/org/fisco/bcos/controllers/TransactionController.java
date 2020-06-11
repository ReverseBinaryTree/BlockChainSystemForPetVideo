package org.fisco.bcos.controllers;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.beans.ContractAddr;
import org.fisco.bcos.beans.CopyrightInfo;
import org.fisco.bcos.beans.TransactionInfo;
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
public class TransactionController {
    @Autowired
    HttpServletRequest request;
    //input:{transaction_id:}
    //output:
    // onSuccess:{status: "ok", info:{....}};
    // onError: todo
    @RequestMapping(value = "/get_transaction_info", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTransactionInfo(@RequestBody JSONObject jsonObject){
        JSONObject ret = new JSONObject();
        Object clientObj = request.getSession().getAttribute("transaction_contract_client");
        //未登录
        if(clientObj == null){
            ret.put("status", "error");
            ret.put("error_type", "client_null");
            return ret.toJSONString();
        }
        TransactionContractClient client = (TransactionContractClient)clientObj;
        String transactionId = (String)jsonObject.get("transaction_id");
        //缺少transaction_id参数
        if(transactionId == null){
            ret.put("status", "error");
            ret.put("error_type", "lack_transaction_id");
            return ret.toJSONString();
        }
        TransactionInfo info = client.getTransactionInfo(transactionId);
        //获取交易信息失败
        if(info == null){
            ret.put("status", "error");
            ret.put("error_type", "info_null");
            return ret.toJSONString();
        }
        ret.put("info", info);
        ret.put("status", "ok");
        return ret.toJSONString();
    }

}
