package com.bizplus.samplecustomer.domain.repository;

import com.bizplus.samplecustomer.domain.dto.CustomerWithContractDto;
import com.bizplus.samplecustomer.domain.entity.Customer;
import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    void create(Customer customer);

    List<Customer> findAllBy();

    List<CustomerWithContractDto> findCustomerWithContractBy();

    Optional<CustomerWithContractDto> findCustomerWithContractBy(Long customerId);

    List<CustomerWithContractDto> searchBy(CustomerContractStatus status, CustomerContractPlan plan);
}
