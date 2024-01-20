package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.dto.CustomerWithContractDto;
import com.bizplus.samplecustomer.domain.entity.Customer;
import com.bizplus.samplecustomer.domain.repository.CustomerRepository;
import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static java.beans.Beans.isInstanceOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CustomerRepositoryImplTest {

    @Autowired private CustomerRepository customerRepository;

    @Test
    @DisplayName("findAllBy 테스트")
    void findAllBy_test() throws Exception {
        // given
        List<Customer> allBy = customerRepository.findAllBy();
        // when
        System.out.println(allBy.size());
        // then
    }

    @Test
    @DisplayName("customer + contract")
    void join_test() throws Exception {
        // given
        // when
        List<CustomerWithContractDto> customerWithContractBy = customerRepository.findCustomerWithContractBy();
        System.out.println(customerWithContractBy.size());
        // then
    }

    @Test
    @DisplayName("customerId where")
    void where_customerId() throws Exception {
        // given
        Long customerId = 5L;
        // when
        Optional<CustomerWithContractDto> customerWithContractBy = customerRepository.findCustomerWithContractBy(customerId);
        // then
        CustomerWithContractDto customerWithContractDto = customerWithContractBy.get();
        System.out.println(customerWithContractDto.getAddress());
        assertThat(customerWithContractDto.getId()).isEqualTo(customerId);
    }

    @Test
    @DisplayName("customerId where Optional test")
    void where_customerIds() throws Exception {
        // given
        Long nonExistentCustomerId = 19999L;

        // when & then
        assertThatThrownBy(() -> customerRepository.findCustomerWithContractBy(nonExistentCustomerId)
                .orElseThrow(() -> new RuntimeException("원하는 예외 메시지")))
                .isInstanceOf(RuntimeException.class)
                ; // 예외 메시지가 있을 경우 추가
    }

    @Test
    @DisplayName("status와 plan으로 검색")
    void searchBy() throws Exception {
        // given
        CustomerContractStatus status = CustomerContractStatus.WAIT;
        CustomerContractPlan plan = CustomerContractPlan.BASIC;

        // when
        List<CustomerWithContractDto> customerWithContractDtos = customerRepository.searchBy(status, plan);
        List<CustomerWithContractDto> customerWithContractDtos1 = customerRepository.searchBy(status, null);
        List<CustomerWithContractDto> customerWithContractDtos2 = customerRepository.searchBy(null, plan);

        // then
        System.out.println(customerWithContractDtos.size());
        System.out.println(customerWithContractDtos1.size());
        System.out.println(customerWithContractDtos2.size());
    }

}