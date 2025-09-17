package org.example.accounts;

import org.example.people.customers.Customer;

public class BankAccount extends BaseBankAccount{
    public BankAccount(Customer customer, double balance) {
        super(customer, balance);
    }

    public BankAccount(Customer customer) {
        super(customer); //balance na 0
    }
}
