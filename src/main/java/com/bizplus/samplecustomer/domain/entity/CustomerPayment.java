package com.bizplus.samplecustomer.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "customer_payments")
@DynamicUpdate
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String publishableKey;

    private String secretKey;

    private String stripeCustomerId;

    private String stripeWebhookId;

    @Column(nullable = false)
    private Long customerId;

    public CustomerPayment(Long customerId) {
        this.customerId = customerId;
    }
}
