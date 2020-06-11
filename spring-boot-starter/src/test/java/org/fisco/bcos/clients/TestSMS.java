package org.fisco.bcos.clients;

import org.fisco.bcos.util.SendMessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSMS {

    @Test
    public void testSMS(){
        String myPhone = "15920948523";
        Integer i = SendMessageUtil.sendCode("666666",myPhone);
        System.out.println("Finish");
        System.out.println("the code is: "+i);
    }
    @Test
    public void testFront(){

    }
}
