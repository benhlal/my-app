package com.benhlal.customer;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@Log
@SpringBootApplication
public class CustomerApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomerApplication.class);
        context.getEnvironment();
        log.info(context.getApplicationName());
        log.info(context.getDisplayName());
        log.info(context.getId());
        log.info(context.getDisplayName());
        Arrays.stream(context.getBeanDefinitionNames()).map(context::getBean)
                .filter(b -> b.getClass().getName().contains("benhlal")).forEach(System.out::println);
        log.info(String.valueOf(context.getBeanDefinitionCount()));
    }
}
