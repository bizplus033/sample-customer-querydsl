package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerPayment;
import com.bizplus.samplecustomer.domain.repository.CustomerPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerPaymentRepositoryImpl implements CustomerPaymentRepository {
    private final JpaCustomerPaymentRepository customerPaymentRepository;

    @Override
    public void create(CustomerPayment customerPayment) {
        customerPaymentRepository.save(customerPayment);
    }
}
