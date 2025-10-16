package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;
import org.example.cards.Card;
import org.example.accounts.transactions.TransactionFactory;
import org.example.accounts.transactions.TransactionLogger;

import java.time.YearMonth;

public class WithdrawService {

    private final TransactionLogger logger;

    public WithdrawService(TransactionLogger logger) {
        this.logger = logger;
    }


    public void withdrawCash(BaseBankAccount account, double amount) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (account.getBalance() < amount) throw new IllegalArgumentException("Not enough balance");

        account.setBalance(account.getBalance() - amount);
        logger.log(TransactionFactory.createCashWithdrawal(account, amount));

        System.out.println("Cash withdrawn: " + amount + " from account " + account.getBankAccountNumber());
    }


    public void withdrawWithCard(Card card, double amount) {
        if (card == null) throw new IllegalArgumentException("Card cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");

        BaseBankAccount account = card.getLinkedAccount();
        if (account == null) throw new IllegalStateException("Card is not linked to any account");


        YearMonth expiration = YearMonth.of(Integer.parseInt(card.getExpirationYear()),
                Integer.parseInt(card.getExpirationMonth()));
        if (expiration.isBefore(YearMonth.now())) {
            throw new IllegalStateException("Card is expired.");
        }

        if (account.getBalance() < amount) throw new IllegalArgumentException("Not enough balance");

        account.setBalance(account.getBalance() - amount);
        logger.log(TransactionFactory.createCardWithdrawal(account, card, amount));

        System.out.println("Withdrawn " + amount + " via card " + card.getCardNumber()
                + " from account " + account.getBankAccountNumber());
    }
}
