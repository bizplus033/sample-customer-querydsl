package com.bizplus.samplecustomer.support;

import com.bizplus.samplecustomer.application.component.CreateCustomerComponent;
import com.bizplus.samplecustomer.application.request.CreateCustomerRequest;
import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.stream.IntStream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class InitData {
    private final CreateCustomerComponent createCustomerComponent;

    private CreateCustomerRequest getRequest() {
        return new CreateCustomerRequest(
                GenerateUtil.generateRandomText(10),
                GenerateUtil.generateRandomText(3),
                GenerateUtil.generateRandomText(5),
                "000-0000-0000",
                GenerateUtil.generateRandomEmail(),
                GenerateUtil.generateRandomText(15),
                GenerateUtil.getRandomEnum(CustomerContractStatus.class),
                GenerateUtil.generateRandomDate(),
                GenerateUtil.generateRandomDate(),
                GenerateUtil.getRandomEnum(CustomerContractPlan.class));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        IntStream.range(0, 25).forEach((i) -> {
            Long customerId = createCustomerComponent.create(getRequest());
            log.info("created customer : {}", customerId);
        });
    }
}
