package org.fisco.bcos.autoconfigure;

import lombok.Data;
import org.fisco.bcos.beans.ContractAddr;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "contract-addr")
public class ContractAddrConfig {
    private String accountContractAddress;
    private String copyrightContractAddress;
    private String marketContractAddress;
    private String transactionContractAddress;
    @Bean
    public ContractAddr getContractAddr(){
        ContractAddr contractAddr = new ContractAddr();
        contractAddr.setAccountContractAddress(accountContractAddress);
        contractAddr.setCopyrightContractAddress(copyrightContractAddress);
        contractAddr.setMarketContractAddress(marketContractAddress);
        contractAddr.setTransactionContractAddress(transactionContractAddress);
        return contractAddr;
    }

}
