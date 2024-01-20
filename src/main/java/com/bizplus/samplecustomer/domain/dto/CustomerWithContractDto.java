package com.bizplus.samplecustomer.domain.dto;

import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class CustomerWithContractDto {

    private final Long id;

    private final String companyName;

    private final String firstName;

    private final String lastName;

    private final String phone;

    private final String email;

    private final String address;


    private final LocalDateTime createdAt;

    private final LocalDateTime updatedAt;
    private final ContractData contract;
    @Getter
    private static class ContractData{
        private final CustomerContractStatus status;

        private final Date startDate;

        private final Date endDate;

        private final CustomerContractPlan plan;

        public ContractData(CustomerContractStatus status, Date startDate, Date endDate, CustomerContractPlan plan) {
            this.status = status;
            this.startDate = startDate;
            this.endDate = endDate;
            this.plan = plan;
        }
    }

    public CustomerWithContractDto(Long id, String companyName, String firstName, String lastName, String phone,
                                   String email, String address, LocalDateTime createdAt, LocalDateTime updatedAt,

                                   CustomerContractStatus contractStatus, Date contractStartDate,
                                   Date contractEndDate, CustomerContractPlan contractPlan) {
        this.id = id;
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.contract = new ContractData(contractStatus, contractStartDate,
                                         contractEndDate, contractPlan);
    }
}
