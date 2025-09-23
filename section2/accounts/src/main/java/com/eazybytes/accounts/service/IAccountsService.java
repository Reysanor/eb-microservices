package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Creates a new account for the given customer.
     *
     * @param customerDto the customer data transfer object containing customer details
     */
    void createAccount(CustomerDto customerDto);
}
