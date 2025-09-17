package org.example.accounts;

import org.example.people.customers.Customer;

import java.util.UUID;

public class BaseBankAccount {
    private String uuid;
    private String bankAccountNumber;
    private Customer customer;

    protected double balance;

    protected BaseBankAccount(Customer customer, double balance) {
        this.uuid = UUID.randomUUID().toString();
        this.bankAccountNumber = "";
        this.customer = customer;
        this.balance = balance;
    }

    protected BaseBankAccount(Customer customer) {
        this(customer, 0);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (balance - amount < 0) {
            throw new IllegalArgumentException("Not enough balance to withdraw");
        }

        balance -= amount;
    }
    public String getUuid() { return uuid; }
    public String getBankAccountNumber() { return bankAccountNumber; }
    public Customer getCustomer() { return customer; }
    public double getBalance() { return balance; }


    public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}