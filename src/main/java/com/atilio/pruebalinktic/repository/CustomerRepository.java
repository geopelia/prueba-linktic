package com.atilio.pruebalinktic.repository;

import com.atilio.pruebalinktic.entity.Customer;
import com.atilio.pruebalinktic.entity.CustomerId;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, CustomerId> {
}