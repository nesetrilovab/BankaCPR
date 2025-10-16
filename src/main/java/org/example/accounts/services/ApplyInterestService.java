package org.example.accounts.services;

import org.example.accounts.SaveAccount;

public class ApplyInterestService {

    public void applyInterest(SaveAccount account) {
        double interest = account.getBalance() * (account.getInterestRate() / 100);
        account.setBalance(account.getBalance() + interest);
        System.out.println("Applied interest: " + interest + " to account " + account.getBankAccountNumber());
    }
}
