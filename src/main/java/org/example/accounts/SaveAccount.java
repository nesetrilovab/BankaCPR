package org.example.accounts;

import org.example.people.customers.Customer;

public class SaveAccount extends BaseBankAccount {
    private double interestRate;


    public SaveAccount(Customer customer, double interestRate) {
        super(customer); // balance na 0
        this.interestRate = interestRate;
    }


    public SaveAccount(Customer customer, double balance, double interestRate) {
        super(customer, balance);
        this.interestRate = interestRate;
    }

    // Getter a Setter
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0) throw new IllegalArgumentException("Interest rate cannot be negative");
        this.interestRate = interestRate;
    }


    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
    }
}
