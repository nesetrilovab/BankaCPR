package org.example.accounts;

import org.example.people.customers.Customer;

import java.time.LocalDate;

public class SaveAccount extends BaseBankAccount {
    private double interestRate;
    private LocalDate lastInterestDate;
    private LocalDate nextInterestDate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, double interestRate) {
        super(uuid, bankAccountNumber, customer, balance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;


        this.lastInterestDate = LocalDate.now();
        this.nextInterestDate = LocalDate.now().plusMonths(1);
    }


    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }


    public LocalDate getLastInterestDate() {
        return lastInterestDate;
    }

    public void setLastInterestDate(LocalDate lastInterestDate) {
        this.lastInterestDate = lastInterestDate;
    }

    public LocalDate getNextInterestDate() {
        return nextInterestDate;
    }

    public void setNextInterestDate(LocalDate nextInterestDate) {
        this.nextInterestDate = nextInterestDate;
    }

}
