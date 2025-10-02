package org.example.accounts;

import org.example.people.customers.Customer;

public class BankAccount extends BaseBankAccount{
    public BankAccount(Customer customer, double balance, String bankAccountNumber) {
        super(customer, balance, bankAccountNumber);
    }

    public BankAccount(Customer customer, String bankAccountNumber) {
        super(customer, bankAccountNumber); //balance na 0
    }
}
