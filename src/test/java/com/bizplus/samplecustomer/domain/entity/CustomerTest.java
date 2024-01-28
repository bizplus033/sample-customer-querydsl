package com.bizplus.samplecustomer.domain.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bizplus.samplecustomer.domain.entity.QCustomer.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerTest {
    @Autowired
    JPAQueryFactory queryFactory;

    @Test
    @DisplayName("동작 확인 테스트")
    void entity_test() throws Exception {
        // given
        QCustomer customer = QCustomer.customer;
        // when
        List<Customer> customers = queryFactory.selectFrom(customer)
                .fetch();

        for (Customer c : customers) {
            System.out.println(c.getFirstName());
        }

        // then
    }

    @Test
    @DisplayName("스태틱 qQlass")
    void sdf() throws Exception {
        // given
        List<Customer> fetch = queryFactory.selectFrom(customer)
                .fetch();
        // when
        Customer customer1 = fetch.get(0);
        System.out.println(customer1.getFirstName());

        // then
    }
}