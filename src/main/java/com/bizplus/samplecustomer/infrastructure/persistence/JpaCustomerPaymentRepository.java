package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerPayment;
import org.springframework.data.repository.Repository;

public interface JpaCustomerPaymentRepository extends Repository<CustomerPayment, Long> {
    void save(CustomerPayment customerPayment);
}
