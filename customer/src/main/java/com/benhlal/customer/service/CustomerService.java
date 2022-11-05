package com.benhlal.customer.service;

import com.benhlal.customer.controller.request.CustomerRegistrationRequest;
import com.benhlal.customer.model.AnomalyCheckResponse;
import com.benhlal.customer.model.Customer;
import com.benhlal.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Slf4j
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        Customer customer1 = customerRepository.saveAndFlush(customer);

        AnomalyCheckResponse response = restTemplate.getForObject("http://ANOMALY/api/v1/anomalies/check/{customerId}", AnomalyCheckResponse.class, customer1.getId());
        log.info("Anomaly response recieved", response);
    }
}
