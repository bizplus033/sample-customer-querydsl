package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerSite;
import com.bizplus.samplecustomer.domain.repository.CustomerSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerSiteRepositoryImpl implements CustomerSiteRepository {
    private final JpaCustomerSiteRepository customerSiteRepository;

    @Override
    public void create(CustomerSite customerSite) {
        customerSiteRepository.save(customerSite);
    }
}
