package org.fisco.bcos.clients;

import org.fisco.bcos.beans.ContractAddr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestYmls {
    @Autowired
    ContractAddr contractAddr;

    @Test
    public void testYml(){
        System.out.println("Hello");
        System.out.println(contractAddr);
    }

}
