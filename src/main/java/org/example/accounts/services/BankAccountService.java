package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.cards.Card;
import org.example.accounts.transactions.TransactionLogger;

public class BankAccountService {

    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final ApplyInterestService applyInterestService;

    public BankAccountService(TransactionLogger logger) {
        this.depositService = new DepositService(logger);
        this.withdrawService = new WithdrawService(logger);
        this.applyInterestService = new ApplyInterestService();
    }

    // Cash deposit
    public void deposit(BaseBankAccount account, double amount) {
        depositService.depositCash(account, amount);
    }



    // Cash withdrawal
    public void withdraw(BaseBankAccount account, double amount) {
        withdrawService.withdrawCash(account, amount);
    }

    // Withdrawal using a card
    public void withdraw(Card card, double amount) {
        withdrawService.withdrawWithCard(card, amount);
    }

    // Apply interest to SaveAccount
    public void applyInterest(SaveAccount account) {
        applyInterestService.applyInterest(account);
    }
}
