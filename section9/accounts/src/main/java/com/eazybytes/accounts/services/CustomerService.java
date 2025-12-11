package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.CustomerDetailsDto;

public interface CustomerService {
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
