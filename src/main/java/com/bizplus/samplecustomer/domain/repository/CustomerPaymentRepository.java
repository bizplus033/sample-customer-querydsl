package com.bizplus.samplecustomer.domain.repository;

import com.bizplus.samplecustomer.domain.entity.CustomerPayment;

public interface CustomerPaymentRepository {
    void create(CustomerPayment customerPayment);
}
