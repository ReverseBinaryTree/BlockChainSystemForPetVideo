package org.fisco.bcos.clients;

import lombok.Data;
import org.fisco.bcos.beans.AccountInfo;
import org.fisco.bcos.constants.GasConstants;
import org.fisco.bcos.contracts.AccountContract;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;

import java.math.BigInteger;
import java.util.ArrayList;

@Data
public class AccountContractClient extends ContractClient{
    AccountContract contract;
    public AccountContractClient(Credentials credentials, String contractAddress, Web3j web3j){
        super(credentials, contractAddress, web3j);
    }

    @Override
    public void load(){
        contract = AccountContract.load(getContractAddress(), web3j, getCredentials(), GasConstants.STATIC_GAS_PROVIDER);
    }

    public Integer addAccount(String name){
        try {
            contract.addAccount(credentials.getAddress(), name).send();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public AccountInfo getAccountInfo(){
        AccountInfo accountInfo = new AccountInfo();
        try {
            Tuple5<String, BigInteger, BigInteger, BigInteger, BigInteger> info = contract.getAccount(credentials.getAddress()).send();
            accountInfo.setName(info.getValue1());
            accountInfo.setBalance(String.valueOf(info.getValue2()));
            accountInfo.setCopyrightsId(new ArrayList<>());
            accountInfo.setTransactionsId(new ArrayList<>());
            accountInfo.setReverseId(new ArrayList<>());
            int numCopyright = info.getValue3().intValue();
            int numTrans = info.getValue4().intValue();
            int numRev = info.getValue5().intValue();
            for(int i = 0; i < numCopyright; i++){
                String id = contract.getCopyrights(credentials.getAddress(), BigInteger.valueOf(i)).send();
                accountInfo.getCopyrightsId().add(id);
            }
            for(int i = 0; i < numTrans; i++){
                BigInteger id = contract.getTransactionId(credentials.getAddress(), BigInteger.valueOf(i)).send();
                accountInfo.getTransactionsId().add(String.valueOf(id));
            }
            for(int i = 0; i < numRev; i++){
                BigInteger id = contract.getRequestionId(credentials.getAddress(), BigInteger.valueOf(i)).send();
                accountInfo.getReverseId().add(String.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return accountInfo;
    }
    public Integer addAccount(String address, String name){
        try {
            contract.addAccount(credentials.getAddress(), name).send();
            return 0;
        }
        catch(Exception e){
            e.printStackTrace();
            return 1;
        }
    }

}
