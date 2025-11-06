package org.example.accounts.factories;

import org.example.accounts.MoneyTransfer;



public class MoneyTransferFactory {
    public MoneyTransfer createDeposit(double amount) {
        return new MoneyTransfer("DEPOSIT", amount);
    }

    public MoneyTransfer createCashWithdrawal(double amount) {
        return new MoneyTransfer("CASH_WITHDRAWAL", amount);
    }
    public MoneyTransfer createCardWithdrawal(double amount) {
        return new MoneyTransfer("CARD_WITHDRAWAL", amount);
    }

    public MoneyTransfer createInterest(double amount) {
        return new MoneyTransfer("INTEREST", amount);
    }
}
