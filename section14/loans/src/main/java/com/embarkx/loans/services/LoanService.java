package com.embarkx.loans.services;

import com.embarkx.loans.dto.LoansDto;

public interface LoanService {
    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);
}
