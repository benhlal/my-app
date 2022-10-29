package com.benhlal.customer.service;

import com.benhlal.customer.controller.request.CustomerRegistrationRequest;
import com.benhlal.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName("youness")
                .lastName("benhlal")
                .email("younes@gmail.com")
                .build();
    }
}
