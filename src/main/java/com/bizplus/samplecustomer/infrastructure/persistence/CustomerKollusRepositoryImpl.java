package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.entity.CustomerKollus;
import com.bizplus.samplecustomer.domain.repository.CustomerKollusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@RequiredArgsConstructor
public class CustomerKollusRepositoryImpl implements CustomerKollusRepository {
    private final JpaCustomerKollusRepository customerKollusRepository;
    @Override
    public void create(CustomerKollus customerKollus) {
        customerKollusRepository.save(customerKollus);
    }
}
