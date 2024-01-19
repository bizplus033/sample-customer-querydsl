package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.Customer;
import com.bizplus.samplecustomer.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final JpaCustomerRepository customerRepository;

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }
}
