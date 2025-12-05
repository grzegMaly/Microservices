package com.embarkx.loans.services;

import com.embarkx.loans.constants.LoanConstants;
import com.embarkx.loans.dto.LoansDto;
import com.embarkx.loans.entity.Loans;
import com.embarkx.loans.exceptions.LoanAlreadyExistsException;
import com.embarkx.loans.exceptions.ResourceNotFoundException;
import com.embarkx.loans.mappers.LoanMapper;
import com.embarkx.loans.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanConstants loanConstants;
    private final LoanMapper loanMapper;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (!optionalLoan.isEmpty()) {
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber: " + mobileNumber);
        }

        loanRepository.save(createNewLoan(mobileNumber));
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        return loanMapper.mapToLoanDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loanRepository.findByLoanNumber(loansDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loansDto.getLoanNumber()));
        loanMapper.mapToLoan(loansDto, loans);
        loanRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loanRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        loanRepository.deleteById(loans.getLoanId());
        return true;
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(loanConstants.HOME_LOAN);
        newLoan.setTotalLoan(loanConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(loanConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }
}
