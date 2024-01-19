package com.bizplus.samplecustomer.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "customer_kollus")
@DynamicUpdate
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerKollus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String contentProviderKey;

    @Column(length = 50)
    private String apiDomain;

    @Column(length = 50)
    private String apiAccessToken;

    @Column(length = 100)
    private String apiSecureKey;

    @Column(length = 100)
    private String apiUserKey;

    @Column(nullable = false)
    private Long customerId;

    public CustomerKollus(Long customerId) {
        this.customerId = customerId;
    }
}
