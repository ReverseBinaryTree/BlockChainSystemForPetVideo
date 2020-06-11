package org.fisco.bcos.clients;

import lombok.Data;
import org.fisco.bcos.beans.CopyrightInfo;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.CopyrightsContract;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CopyrightContractClient extends ContractClient{
    CopyrightsContract contract;
    public CopyrightContractClient(Credentials credentials, String contractAddress, Web3j web3j){
        super(credentials, contractAddress, web3j);
    }

    @Override
    public void load(){
        contract = CopyrightsContract.load(getContractAddress(), getWeb3j(), getCredentials(), GasConstants.STATIC_GAS_PROVIDER);
    }

    public CopyrightInfo getCopyrightInfo(String copyrightId){
        CopyrightInfo copyrightInfo = new CopyrightInfo();
        try {
            Tuple6<String,String, BigInteger, BigInteger,String,Boolean>  info = contract.getCopyrightInfo(copyrightId).send();
            copyrightInfo.setCopyrightId(info.getValue1());
            copyrightInfo.setTag(info.getValue2());
            copyrightInfo.setDate(stampToDate(String.valueOf(info.getValue3())));
            copyrightInfo.setPrice(String.valueOf(info.getValue4()));
            copyrightInfo.setOwner(info.getValue5());
            copyrightInfo.setOnSale(info.getValue6());
            System.out.println("-------------------------------copInfo in the client----------------------");
            System.out.println(copyrightInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return copyrightInfo;
    }

    public Integer setCopyrightPrice(String copId, String price){
        try {
            contract.setCopyrightPrice(copId, new BigInteger(price)).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}
