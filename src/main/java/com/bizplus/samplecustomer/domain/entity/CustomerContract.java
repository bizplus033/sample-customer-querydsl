package com.bizplus.samplecustomer.domain.entity;

import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_contracts")
@DynamicUpdate
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @ColumnDefault("'WAIT")
    private CustomerContractStatus status;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private CustomerContractPlan plan;

    @Column(nullable = false)
    private Long customerId;

    public CustomerContract(CustomerContractStatus status, Date startDate, Date endDate, CustomerContractPlan plan, Long customerId) {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
        this.customerId = customerId;
    }
}
