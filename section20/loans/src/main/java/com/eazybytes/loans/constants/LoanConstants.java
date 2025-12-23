package com.eazybytes.loans.constants;

import org.springframework.stereotype.Component;

@Component
public class LoanConstants {

    public final String HOME_LOAN = "Home Loan";
    public final int NEW_LOAN_LIMIT = 100_000;
    public final String STATUS_200= "200";
    public final String MESSAGE_200= "Request processed successfully";
    public final String STATUS_201= "201";
    public final String MESSAGE_201= "Loan created successfully";
    public final String STATUS_417= "415";
    public final String MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
    public final String MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";
}
