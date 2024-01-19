package com.bizplus.samplecustomer.domain.type;

import lombok.Getter;

@Getter
public enum CustomerSiteDomainType {
    MOK("MOK"),
    CUSTOMER("CUSTOMER"),
    UNKNOWN("UNKNOWN");

    @Getter
    private final String domainType;

    CustomerSiteDomainType(String domainType) {
        this.domainType = domainType;
    }
}
