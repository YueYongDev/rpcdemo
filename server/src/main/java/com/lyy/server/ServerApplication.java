package com.lyy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);

        System.out.println("*************************************************");
        System.out.println("RPC Server start successfully!");
        System.out.println("Ready to receive Client call.");
    }

}
