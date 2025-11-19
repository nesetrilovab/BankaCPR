package org.example.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.MoneyTransfer;
import org.example.accounts.factories.MoneyTransferFactory;
import org.example.accounts.transactions.TransactionFactory;
import org.example.accounts.transactions.TransactionLogger;

@Singleton
public class DepositService {

    private final TransactionLogger logger;
    private final MoneyTransferFactory moneyTransferFactory;

    @Inject
    public DepositService(TransactionLogger logger, MoneyTransferFactory moneyTransferFactory) {
        this.logger = logger;
        this.moneyTransferFactory = moneyTransferFactory;
    }

    public void depositCash(BaseBankAccount account, double amount) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");

        // Update balance
        account.setBalance(account.getBalance() + amount);

        // Log transaction
        logger.log(TransactionFactory.createCashDeposit(account, amount));

        // Add transfer to account's MoneyTransfer list
        MoneyTransfer transfer = moneyTransferFactory.createDeposit(amount);
        account.addTransfer(transfer);

        // Optional: console output for debugging
        System.out.println("Deposited " + amount + " to account " + account.getBankAccountNumber());
    }
}
