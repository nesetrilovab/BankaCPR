package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.transactions.TransactionFactory;
import org.example.accounts.transactions.TransactionLogger;

public class DepositService {

    private final TransactionLogger logger;

    public DepositService(TransactionLogger logger) {
        this.logger = logger;
    }


    public void depositCash(BaseBankAccount account, double amount) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");

        account.setBalance(account.getBalance() + amount);
        logger.log(TransactionFactory.createCashDeposit(account, amount));

        System.out.println("Deposited " + amount + " to account " + account.getBankAccountNumber());
    }
}
