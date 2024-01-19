package com.bizplus.samplecustomer.application.request;

import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class CreateCustomerRequest {

    @NotBlank
    private String companyName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    private String address;

    @NotNull
    private CustomerContractStatus contractStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date contractStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date contractEndDate;

    @NotNull
    private CustomerContractPlan contractPlan;

    public CustomerContractData toCustomerContractData() {
        return new CustomerContractData(contractStatus, contractStartDate, contractEndDate, contractPlan);
    }

    public CreateCustomerRequest(String companyName, String firstName, String lastName, String phone, String email, String address, CustomerContractStatus contractStatus, Date contractStartDate, Date contractEndDate, CustomerContractPlan contractPlan) {
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contractStatus = contractStatus;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractPlan = contractPlan;
    }

}
