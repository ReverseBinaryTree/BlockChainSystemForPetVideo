package org.fisco.bcos.clients;

import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.beans.ContractAddr;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.util.KeyUtil;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestContracts {
    @Autowired
    ContractAddr contractAddr;
    @Autowired
    Web3j web3j;
    @Autowired
    Credentials credentials;

    @Test
    public void testContracts(){
        KeyUtil.UserKey userKey = KeyUtil.createUserKey();
        Credentials credentials1 = GenCredential.create(userKey.getPrivateKey());
        AccountContract accountContract = AccountContract.load(contractAddr.getAccountContractAddress(),web3j,credentials1, GasConstants.STATIC_GAS_PROVIDER);
        CopyrightsContract copyrightsContract = CopyrightsContract.load(contractAddr.getCopyrightContractAddress(),web3j,credentials1,GasConstants.STATIC_GAS_PROVIDER);

        System.out.println("User Keys: ");
        System.out.println("private key: "+ userKey.getPrivateKey());
        System.out.println("public key: "+ userKey.getPublicKey());
        System.out.println("User Address: "+ userKey.getAddress());

        AccountContractClient accountContractClient = new AccountContractClient(credentials1,contractAddr.getAccountContractAddress(),web3j);
        accountContractClient.addAccount("UnitTest1");
        AccountInfo accountInfo1 = accountContractClient.getAccountInfo();
        System.out.println(accountInfo1.getName());
        System.out.println(accountInfo1.getBalance());
        RemoteCall<String> name2 = accountContract.getName(userKey.getAddress());
        System.out.println("name2: "+ name2.toString());




    }
    @Test
    public void testKeys(){
        KeyUtil.UserKey key = KeyUtil.createUserKey();
        System.out.println("--------generate done ------");
        System.out.println("public key: "+key.getPublicKey());
        System.out.println("private key:"+ key.getPrivateKey());
        System.out.println("address: " + key.getAddress());
        System.out.println("---------------check----------");
        System.out.println("the public key after compute: "+KeyUtil.getPublicKey(key.getPrivateKey()));
        Credentials credentials = GenCredential.create(key.getPrivateKey());
        System.out.println("-----check by credentials-----");
        System.out.println("the public key of it is: "+ KeyUtil.getPublicKey(credentials));

    }




}
