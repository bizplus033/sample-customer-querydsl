package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.Customer;
import org.springframework.data.repository.Repository;

public interface JpaCustomerRepository extends Repository<Customer, Long > {

    void save(Customer customer);
}
