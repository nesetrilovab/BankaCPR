package org.example.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.SaveAccount;
@Singleton
public class ApplyInterestService {
    @Inject
    public void applyInterest(SaveAccount account) {
        double interest = account.getBalance() * (account.getInterestRate() / 100);
        account.setBalance(account.getBalance() + interest);
        System.out.println("Applied interest: " + interest + " to account " + account.getBankAccountNumber());
    }
}
