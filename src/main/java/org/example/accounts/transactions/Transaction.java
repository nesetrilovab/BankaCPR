package org.example.accounts.transactions;

import org.example.accounts.BaseBankAccount;
import org.example.cards.Card;

import java.time.LocalDateTime;

public class Transaction {
    public enum Type { DEPOSIT_CASH, WITHDRAWAL_CASH, WITHDRAWAL_CARD }

    private final Type type;
    private final BaseBankAccount account;
    private final Card card;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(Type type, BaseBankAccount account, Card card, double amount) {
        this.type = type;
        this.account = account;
        this.card = card;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }


    public Type getType() { return type; }
    public BaseBankAccount getAccount() { return account; }
    public Card getCard() { return card; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    /*@Override
    public String toString() {
        String cardInfo = (card != null) ? " via card " + card.getCardNumber() : "";
        return "[" + timestamp + "] " + type + ": " + amount + " on account "
                + account.getBankAccountNumber() + cardInfo;
    }*/
}
