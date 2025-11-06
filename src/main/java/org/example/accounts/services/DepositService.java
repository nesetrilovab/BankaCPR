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
    @Inject
    private final TransactionLogger logger;
private final MoneyTransferFactory moneyTransferFactory = new  MoneyTransferFactory();
    public DepositService(TransactionLogger logger) {
        this.logger = logger;
    }


    public void depositCash(BaseBankAccount account, double amount) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");

        account.setBalance(account.getBalance() + amount);
        logger.log(TransactionFactory.createCashDeposit(account, amount));
MoneyTransfer transfer = moneyTransferFactory.createDeposit(amount);
account.addTransfer(transfer);
        System.out.println("Deposited " + amount + " to account " + account.getBankAccountNumber());
    }
}
