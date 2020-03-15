package com.crowdchain.crowdchaindemo;

import com.crowdchain.crowdchaindemo.chaincode.invocation.InvokeChaincode;
import com.crowdchain.crowdchaindemo.network.CreateChannel;
import com.crowdchain.crowdchaindemo.network.DeployInstantiateChaincode;
import com.crowdchain.crowdchaindemo.user.RegisterEnrollUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdchaindemoApplication {

    public static void main(String[] args) {
        //new CreateChannel().createChannel();
        //new DeployInstantiateChaincode().deployInstantiateChaincode();
        //new RegisterEnrollUser().registerEnrollUser();;
        //new InvokeChaincode().invokeChaincode();


        SpringApplication.run(CrowdchaindemoApplication.class, args);
    }

}
