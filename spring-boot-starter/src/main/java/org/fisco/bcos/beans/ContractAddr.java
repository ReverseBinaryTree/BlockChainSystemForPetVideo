package org.fisco.bcos.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Data
public class ContractAddr {
    private String accountContractAddress;
    private String copyrightContractAddress;
    private String transactionContractAddress;
    private String marketContractAddress;


    @Override
    public String toString() {
        return "ContractAddr{" +
                "accountContractAddress='" + accountContractAddress + '\'' +
                ", copyrightContractAddress='" + copyrightContractAddress + '\'' +
                ", transactionContractAddress='" + transactionContractAddress + '\'' +
                ", marketContractAddress='" + marketContractAddress + '\'' +
                '}';
    }





//    public static  void main(String []args){
//        ContractAddr contractAddr = new ContractAddr();
//        contractAddr.setAccountContractAddress("0x037dcced9d0ad25932c8548abc2796d8843ff385");
//        System.out.println(contractAddr.getAccountContractAddress());
//    }

}
