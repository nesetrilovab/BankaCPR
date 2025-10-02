package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;

public class DepositService {


    public void deposit(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        account.setBalance(account.getBalance() + amount);
    }
}
