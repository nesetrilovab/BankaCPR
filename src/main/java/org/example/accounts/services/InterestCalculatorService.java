package org.example.accounts.services;

import org.example.accounts.SaveAccount;

public class InterestCalculatorService {

    public double calculate(SaveAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }

        double interest = account.getBalance() * (account.getInterestRate() / 100);
        return interest;
    }
}
