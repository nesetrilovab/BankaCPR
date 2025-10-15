package org.example.accounts;

import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.people.customers.Customer;

public class SaveAccount extends BaseBankAccount {
    private double interestRate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, double interestRate) {
        super(uuid, bankAccountNumber, customer, balance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
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
}
