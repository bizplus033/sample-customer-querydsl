package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerSite;
import org.springframework.data.repository.Repository;

public interface JpaCustomerSiteRepository extends Repository<CustomerSite, Long> {
    void save(CustomerSite customerSite);
}
