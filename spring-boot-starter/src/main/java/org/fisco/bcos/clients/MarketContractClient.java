package org.fisco.bcos.clients;

import lombok.Data;
import org.fisco.bcos.beans.CopyrightInfo;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.MarketContract;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class MarketContractClient extends ContractClient {
    MarketContract contract;

    public MarketContractClient(Credentials credentials, String contractAddress, Web3j web3j) {
        super(credentials, contractAddress, web3j);
    }

    @Override
    public void load() {
        contract = MarketContract.load(getContractAddress(), getWeb3j(), getCredentials(), GasConstants.STATIC_GAS_PROVIDER);
    }

    //todo
    public List<String> getCopyrightsOnSale() {
        List<String> ret = new ArrayList<>();
        try {
            int num = contract.getCopyrightsOnSaleNum().send().intValue();
            for (int i = 0; i < num; i++) {
                ret.add(contract.getAddressOfCopyrightsOnSale(BigInteger.valueOf(i)).send());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ret;
    }

    public Integer buyCopyright(String copyrightId) {
        try {
            contract.buyCopyright(credentials.getAddress(), copyrightId).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public Integer pullCopyright(String copyrightId) {
        try {
            contract.pullCopyright(copyrightId).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public Integer pushCopyright(String copyrightId, BigInteger amount) {
        try {
            System.out.println(copyrightId + " : " + amount);
            contract.pushCopyright(copyrightId, amount).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
    public Integer giveCopyrightTo(String fromWho, String toWho, String CopyrightId){
        try{
            contract.giveTo(fromWho,toWho,CopyrightId).send();
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return 1;
        }
    }
    public CopyrightInfo creatCopyrightAndGiveTo(String toWho, String tag, String hashOfVideo){
        CopyrightInfo copInfo = new CopyrightInfo();
        try{
            TransactionReceipt receipt = contract.createCopyrightAndGiveTo(toWho,tag,hashOfVideo).send();
            List<MarketContract.CreateCopyrightAndGiveToEventResponse> response = contract.getCreateCopyrightAndGiveToEvents(receipt);
            if(!response.isEmpty()){
                copInfo.setCopyrightId(response.get(0).copyrightId);
                copInfo.setTag(response.get(0).tag);
                copInfo.setDate(String.valueOf(response.get(0).date));
                copInfo.setOnSale(false);
                copInfo.setOwner(response.get(0).owner);
                copInfo.setPrice("0");
                System.out.println("create copyright: "+ copInfo);
            }
            System.out.println("create copyright: "+ copInfo);
            return copInfo;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return copInfo;

    }
    public Integer recharge(String amount){
        try {
            contract.recharge(credentials.getAddress(), new BigInteger(amount)).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
    public Integer recharge(String who, String amount){
        try{
            contract.recharge(who,new BigInteger(amount)).send();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }


}
