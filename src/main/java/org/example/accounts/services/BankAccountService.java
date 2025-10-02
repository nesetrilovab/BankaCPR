package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;

public class BankAccountService {

    private final DepositService depositService;
    private final CheckDepositLimitService checkDepositLimitService;

    public BankAccountService() {
        this.depositService = new DepositService();
        this.checkDepositLimitService = new CheckDepositLimitService();
    }

    public void deposit(BaseBankAccount account, double amount) {
        checkDepositLimitService.checkDeposit(account, amount);
        depositService.deposit(account, amount);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (account.getBalance() - amount < 0) throw new IllegalArgumentException("Not enough balance");
        account.setBalance(account.getBalance() - amount);
    }

    public void applyInterest(SaveAccount account) {
        double interest = account.getBalance() * (account.getInterestRate() / 100);
        account.setBalance(account.getBalance() + interest);
    }
}
