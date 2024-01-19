package com.bizplus.samplecustomer.domain.type;

import lombok.Getter;

@Getter
public enum CustomerContractPlan {
    TRAIL(1073741824L, false, false),
    BASIC(107374182400L, false, false),
    STANDARD(268435456000L, true, false),
    PREMIUM(536870912000L, true, true),
    UNLIMITED(0L, true, true);


    private final long storage;
    private final boolean payment;
    private final boolean live;

    CustomerContractPlan(long storage, boolean payment, boolean live) {
        this.storage = storage;
        this.payment = payment;
        this.live = live;
    }
}
