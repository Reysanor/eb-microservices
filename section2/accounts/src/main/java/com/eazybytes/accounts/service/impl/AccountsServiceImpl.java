package com.eazybytes.accounts.service.impl;

import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import com.eazybytes.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     * Creates a new account for the given customer.
     *
     * @param customerDto the customer data transfer object containing customer details
     */
    @Override
    public void createAccount(com.eazybytes.accounts.dto.CustomerDto customerDto) {
        // Implementation logic to create an account for the given customer
        // This could involve saving the customer details to a database
        System.out.println("Account created for customer: " + customerDto.getName());
    }
}
