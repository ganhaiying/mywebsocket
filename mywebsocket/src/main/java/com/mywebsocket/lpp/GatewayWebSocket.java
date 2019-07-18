package com.mywebsocket.lpp;

import org.springframework.context.ApplicationContext;

public class GatewayWebSocket {
    private static ApplicationContext applicationContext;
    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }
}
