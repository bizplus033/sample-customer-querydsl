package com.bizplus.samplecustomer.application.request;

import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.util.Date;

@Getter
public class CustomerContractData {
    private final CustomerContractStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final Date endDate;

    private final CustomerContractPlan plan;

    public CustomerContractData(CustomerContractStatus status, Date startDate, Date endDate, CustomerContractPlan plan) {
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.plan = plan;
    }
}
