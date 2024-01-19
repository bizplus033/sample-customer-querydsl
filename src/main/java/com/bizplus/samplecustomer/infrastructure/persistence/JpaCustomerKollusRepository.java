package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerKollus;
import org.springframework.data.repository.Repository;

public interface JpaCustomerKollusRepository extends Repository<CustomerKollus, Long> {
    void save(CustomerKollus customerKollus);
}
