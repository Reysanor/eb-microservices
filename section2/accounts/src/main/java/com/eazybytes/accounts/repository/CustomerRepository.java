package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Customer entity operations.
 *
 * Extends JpaRepository to provide CRUD operations and
 */
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobileNumber(String mobileNumber);

}
