package org.example.cards;

import org.example.accounts.BaseBankAccount;
import java.time.LocalDate;
import java.time.YearMonth;

public class Card {
    public String cardNumber;
    public String expirationMonth;
    public String expirationYear;
    public String cvc;
    public String owner;
    private BaseBankAccount linkedAccount;

    public Card(String cardNumber, String expirationMonth, String expirationYear, String cvc, String owner) {
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cvc = cvc;
        this.owner = owner;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public YearMonth getExpirationYearMonth() {
        int month = Integer.parseInt(expirationMonth);
        int year = Integer.parseInt(expirationYear);
        return YearMonth.of(year, month);
    }

    public LocalDate getExpirationDate() {
        YearMonth ym = getExpirationYearMonth();
        return ym.atEndOfMonth();
    }

    public String getCvc() {
        return cvc;
    }

    public String getOwner() {
        return owner;
    }

    public BaseBankAccount getLinkedAccount() {
        return linkedAccount;
    }

    public void linkToAccount(BaseBankAccount account) {
        if (this.linkedAccount != null) {
            throw new IllegalStateException("This card is already linked to an account.");
        }
        this.linkedAccount = account;
    }
}
