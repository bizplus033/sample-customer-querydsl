package com.bizplus.samplecustomer.api;

import com.bizplus.samplecustomer.application.CustomerService;
import com.bizplus.samplecustomer.application.request.CreateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CreateCustomerRequest request) {
        Long customerId = customerService.create(request);
        return new ResponseEntity<>(customerId, HttpStatus.CREATED);
    }
}
