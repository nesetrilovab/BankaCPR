package org.example.accounts;

import java.time.LocalDateTime;


public class MoneyTransfer {
    private LocalDateTime date;
    private String type;
    private double amount;
    private boolean hasBeenExported;
    public MoneyTransfer(String type, double amount) {
        this.date = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.hasBeenExported = false;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public boolean hasBeenTransferred() {
        return hasBeenExported;
    }

    public void markAsTransferred() {
        this.hasBeenExported = true;
    }

    @Override
    public String toString() {
        return "MoneyTransfer{" +
                "date=" + date +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", hasBeenTransferred=" + hasBeenExported +
                '}';
    }

}
