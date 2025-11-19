package org.example.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.SaveAccount;

import java.time.LocalDate;

@Singleton
public class ApplyInterestService {

    private final InterestCalculatorService interestCalculator;

    @Inject
    public ApplyInterestService(InterestCalculatorService interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public double applyInterest(SaveAccount account) {
        double interest = interestCalculator.calculate(account);
        account.setBalance(account.getBalance() + interest);
        account.setLastInterestDate(LocalDate.now());
        account.setNextInterestDate(LocalDate.now().plusMonths(1)); // adjust if needed
        return interest;
    }
}
