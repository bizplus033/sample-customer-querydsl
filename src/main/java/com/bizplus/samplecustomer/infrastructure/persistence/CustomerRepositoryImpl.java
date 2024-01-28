package com.bizplus.samplecustomer.infrastructure.persistence;

import com.bizplus.samplecustomer.domain.dto.CustomerWithContractDto;
import com.bizplus.samplecustomer.domain.dto.QCustomerWithContractDto;
import com.bizplus.samplecustomer.domain.entity.Customer;
import com.bizplus.samplecustomer.domain.repository.CustomerRepository;
import com.bizplus.samplecustomer.domain.type.CustomerContractPlan;
import com.bizplus.samplecustomer.domain.type.CustomerContractStatus;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.bizplus.samplecustomer.domain.entity.QCustomer.customer;
import static com.bizplus.samplecustomer.domain.entity.QCustomerContract.customerContract;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final JpaCustomerRepository customerRepository;
    private final JPAQueryFactory query;

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllBy() {
        return query.selectFrom(customer)
                .orderBy(customer.createdAt.desc())
        .fetch();
    }

    @Override
    public List<CustomerWithContractDto> findCustomerWithContractBy() {
        List<CustomerWithContractDto> fetch = query.select(selectCustomerWithContract())
                .from(customer)
                .innerJoin(customerContract).on(customer.id.eq(customerContract.customerId))
                .fetch();


        return fetch;
    }

    @Override
    public Optional<CustomerWithContractDto> findCustomerWithContractBy(Long customerId) {
        return Optional.ofNullable(
                query.select(selectCustomerWithContract())
                .from(customer)
                .innerJoin(customerContract).on(customer.id.eq(customerContract.customerId))
                .where(customer.id.eq(customerId))
                .fetchFirst()
        );

    }

    private BooleanBuilder toBooleanBuilder(CustomerContractStatus status, CustomerContractPlan plan) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(eqCustomerContractPlan(plan));
        builder.and(eqCustomerContractStatus(status));
        return builder;
    }

    @Override
    public List<CustomerWithContractDto> searchBy(CustomerContractStatus status, CustomerContractPlan plan) {

        BooleanBuilder booleanBuilder = toBooleanBuilder(status, plan);
        List<CustomerWithContractDto> fetch = query.select(selectCustomerWithContract())
                .from(customer)
                .innerJoin(customerContract).on(customer.id.eq(customerContract.customerId))
                .where(booleanBuilder)
                .fetch();
        return fetch;
    }

    private BooleanExpression eqCustomerContractStatus(CustomerContractStatus status) {
        return status != null ? customerContract.status.eq(status) : null;
    }

    private BooleanExpression eqCustomerContractPlan(CustomerContractPlan plan) {
        return plan != null ? customerContract.plan.eq(plan) : null;
    }
    private ConstructorExpression<CustomerWithContractDto> selectCustomerWithContract() {
        return new QCustomerWithContractDto(
                customer.id,
                customer.companyName,
                customer.firstName,
                customer.lastName,
                customer.phone,
                customer.email,
                customer.address,
                customer.createdAt,
                customer.updatedAt,
                customerContract.status,
                customerContract.startDate,
                customerContract.endDate,
                customerContract.plan
        );
    }
    // select * (select count() from categories where categories.customer_id ) from customer
}
