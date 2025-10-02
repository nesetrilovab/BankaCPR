package org.example.accounts;

import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.people.customers.Customer;

public class SaveAccount extends BaseBankAccount {
    private double interestRate;


    public SaveAccount(Customer customer, double interestRate, String bankAccountNumber) {
        super(customer, bankAccountNumber); // balance na 0
        this.interestRate = interestRate;
    }


    public SaveAccount(Customer customer, double balance, double interestRate, String bankAccountNumber) {
        super(customer, balance, bankAccountNumber);
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


}
