package com.mywebsocket;

import com.mywebsocket.lpp.GatewayWebSocket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com")
public class RangerSocketApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RangerSocketApplication.class, args);
        GatewayWebSocket.setApplicationContext(applicationContext);
    }

}
