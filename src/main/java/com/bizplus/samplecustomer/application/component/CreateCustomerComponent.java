package com.bizplus.samplecustomer.application.component;

import com.bizplus.samplecustomer.application.request.CreateCustomerRequest;
import com.bizplus.samplecustomer.application.request.CustomerContractData;
import com.bizplus.samplecustomer.domain.entity.*;
import com.bizplus.samplecustomer.domain.repository.*;
import com.bizplus.samplecustomer.domain.type.CustomerSiteDomainType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateCustomerComponent {
    private final CustomerRepository customerRepository;
    private final CustomerContractRepository customerContractRepository;
    private final CustomerPaymentRepository customerPaymentRepository;
    private final CustomerKollusRepository customerKollusRepository;
    private final CustomerSiteRepository customerSiteRepository;

    private Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(request.getCompanyName(),
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                request.getEmail(),
                request.getAddress());

        customerRepository.create(customer);
        return customer;
    }

    private void createCustomerContract(Long customerId, CustomerContractData data) {
        CustomerContract customerContract = new CustomerContract(data.getStatus(), data.getStartDate(), data.getEndDate(), data.getPlan(), customerId);
        customerContractRepository.create(customerContract);
    }

    private void createCustomerPayment(Long customerId) {
        CustomerPayment customerPayment = new CustomerPayment(customerId);
        customerPaymentRepository.create(customerPayment);
    }

    private void createCustomerKollus(Long customerId) {
        CustomerKollus customerKollus = new CustomerKollus(customerId);
        customerKollusRepository.create(customerKollus);
    }

    private void createCustomerSite(Long customerId) {
        CustomerSite customerSite = new CustomerSite(false, CustomerSiteDomainType.MOK, "https://project.com", customerId);
        customerSiteRepository.create(customerSite);
    }

    @Transactional
    public Long create(CreateCustomerRequest request) {
        Customer customer = createCustomer(request);
        createCustomerContract(customer.getId(), request.toCustomerContractData());
        createCustomerPayment(customer.getId());
        createCustomerKollus(customer.getId());
        createCustomerSite(customer.getId());

        return customer.getId();
    }
}
