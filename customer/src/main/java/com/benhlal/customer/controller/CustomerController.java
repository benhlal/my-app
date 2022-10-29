package com.benhlal.customer.controller;

import com.benhlal.customer.controller.request.CustomerRegistrationRequest;
import com.benhlal.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/customers")
@RestController
public record CustomerController(CustomerService customerService) {


    @PostMapping("/register")
    public void register(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("customer request {} ", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
