package com.mergen.vtys.vtysdatabaseap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(/*exclude = {SecurityAutoConfiguration.class}*/)
public class VtysDatabaseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtysDatabaseApiApplication.class, args);
    }

}
