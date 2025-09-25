package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

/**
 * Service interface for managing accounts.
 * Make operations on database like create account (from CustomerDto)
 * or get account details by customer id.
 */
public interface IAccountsService {

    /**
     * Creates a new account for the given customer.
     *
     * @param customerDto the customer data transfer object containing customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);

}
