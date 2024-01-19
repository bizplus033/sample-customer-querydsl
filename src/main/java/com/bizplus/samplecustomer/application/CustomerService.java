package com.bizplus.samplecustomer.application;

import com.bizplus.samplecustomer.application.component.CreateCustomerComponent;
import com.bizplus.samplecustomer.application.request.CreateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CreateCustomerComponent createCustomerComponent;

    public Long create(CreateCustomerRequest request) {
        return createCustomerComponent.create(request);
    }
}
