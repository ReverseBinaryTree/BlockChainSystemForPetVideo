package org.fisco.bcos.clients;

import org.fisco.bcos.beans.TestKey;
import org.fisco.bcos.util.KeyUtil;
import org.junit.jupiter.api.Test;

import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.beans.ContractAddr;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.*;

class MarketContractClientTest {
    @Autowired
    Web3j web3j;
    @Autowired
    Credentials credentials;
    @Autowired
    ContractAddr contractAddr;
    @Autowired
    TestKey keys;

    @Test
    public void totalTest(){
        String key[] = {keys.getUser1(), keys.getUser2(), keys.getUser3()};
        String addresses[] = {KeyUtil.getAddress(key[0]), KeyUtil.getAddress(key[1]), KeyUtil.getAddress(key[2])};
        Credentials cred[] = {Credentials.create(key[0]), Credentials.create(key[1]), Credentials.create(key[2])};
        MarketContractClient marketClient1 = new MarketContractClient(cred[0], contractAddr.getMarketContractAddress(), web3j);
        MarketContractClient marketClient2 = new MarketContractClient(cred[1], contractAddr.getMarketContractAddress(), web3j);
        AccountContractClient accountClient1 = new AccountContractClient(cred[0], contractAddr.getAccountContractAddress(), web3j);
        AccountContractClient accountClient2 = new AccountContractClient(cred[1], contractAddr.getAccountContractAddress(), web3j);

        //add accounts
        //添加用户
        accountClient1.addAccount("hello");
        accountClient2.addAccount("world");

        marketClient1.creatCopyrightAndGiveTo(keys.getUser1(),"goldenhair","bf17f4ab50fe9cb9e90ac041351d3946");
        marketClient2.creatCopyrightAndGiveTo(keys.getUser2(),"bluecat","3b373bf64736faa2eefd142949304594");


    }
    public static void main(String [] args){

    }
}