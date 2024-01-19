package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerContract;
import com.bizplus.samplecustomer.domain.repository.CustomerContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerContractRepositoryImpl implements CustomerContractRepository {
    private final JpaCustomerContractRepository customerContractRepository;
    @Override
    public void create(CustomerContract customerContract) {
        customerContractRepository.save(customerContract);
    }
}
