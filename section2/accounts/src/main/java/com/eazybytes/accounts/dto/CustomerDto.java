package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Customer name cannot be empty")
    @Size(min = 5,max = 30,message = "Customer name should have 5 - 30 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be exactly 9 digits")
    private String mobileNumber;


    private AccountsDto accountsDto;
}
