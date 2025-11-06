package org.example.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.MoneyTransfer;
import org.example.accounts.factories.MoneyTransferFactory;
import org.example.cards.Card;
import org.example.accounts.transactions.TransactionFactory;
import org.example.accounts.transactions.TransactionLogger;

import java.time.YearMonth;
@Singleton
public class WithdrawService {
    @Inject
    private final TransactionLogger logger;

    public WithdrawService(TransactionLogger logger) {
        this.logger = logger;
    }
private final MoneyTransferFactory moneyTransferFactory = new MoneyTransferFactory();

    public void withdrawCash(BaseBankAccount account, double amount) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (account.getBalance() < amount) throw new IllegalArgumentException("Not enough balance");

        account.setBalance(account.getBalance() - amount);
        logger.log(TransactionFactory.createCashWithdrawal(account, amount));
        MoneyTransfer transfer = moneyTransferFactory.createCashWithdrawal(amount);
        account.addTransfer(transfer);
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
        MoneyTransfer transfer = moneyTransferFactory.createCardWithdrawal(amount);
        account.addTransfer(transfer);
        System.out.println("Withdrawn " + amount + " via card " + card.getCardNumber()
                + " from account " + account.getBankAccountNumber());
    }
}
