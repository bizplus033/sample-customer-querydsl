package com.bizplus.samplecustomer.domain.entity;

import com.bizplus.samplecustomer.domain.type.CustomerSiteDomainType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "customer_sites")
@DynamicUpdate
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean useSite;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private CustomerSiteDomainType domainType;

    private String domain;

    @Column(nullable = false)
    private Long customerId;

    public CustomerSite(Boolean useSite, CustomerSiteDomainType domainType, String domain, Long customerId) {
        this.useSite = useSite;
        this.domainType = domainType;
        this.domain = domain;
        this.customerId = customerId;
    }
}
