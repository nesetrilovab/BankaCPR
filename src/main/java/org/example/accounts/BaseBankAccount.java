package org.example.accounts;

import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.cards.Card;
import org.example.people.customers.Customer;

import java.util.ArrayList;
import java.util.List;


public class BaseBankAccount {
    private final String uuid;
    private final String bankAccountNumber;
    private Customer customer;
    private double balance;


    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;

    }


    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer) {
        this(uuid, bankAccountNumber, customer, 0.0);
    }



    public String getUuid() { return uuid; }
    public String getBankAccountNumber() { return bankAccountNumber; }
    public Customer getCustomer() { return customer; }
    public double getBalance() { return balance; }


    public void setBalance(double balance) { this.balance = balance; }
    public void setCustomer(Customer customer) { this.customer = customer; }


}