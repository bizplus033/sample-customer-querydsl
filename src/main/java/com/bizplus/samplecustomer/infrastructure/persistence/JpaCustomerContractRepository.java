package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerContract;
import org.springframework.data.repository.Repository;

public interface JpaCustomerContractRepository extends Repository<CustomerContract, Long> {
    void save(CustomerContract customerContract);
}
