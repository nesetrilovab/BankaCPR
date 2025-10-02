package org.example.accounts;

import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.people.customers.Customer;

import java.util.UUID;

public class BaseBankAccount {
    private String uuid;
    private String bankAccountNumber;
    private Customer customer;

    private double balance;

    public BaseBankAccount(Customer customer, double balance, String bankAccountNumber) {
        this.uuid = UUID.randomUUID().toString();

        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public BaseBankAccount(Customer customer, String bankAccountNumber ) {
        this(customer, 0, bankAccountNumber);
    }


    public String getUuid() { return uuid; }
    public String getBankAccountNumber() { return bankAccountNumber; }
    public Customer getCustomer() { return customer; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void setCustomer(Customer customer) { this.customer = customer; }
}