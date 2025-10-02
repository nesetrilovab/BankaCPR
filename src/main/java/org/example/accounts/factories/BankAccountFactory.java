package org.example.accounts.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.people.customers.Customer;

public class BankAccountFactory {
    private final BankAccountNumberGenerator generator = new BankAccountNumberGenerator();

    public BaseBankAccount createBaseAccount(Customer customer, double balance) {
        return new BaseBankAccount(customer, balance, generator.generate());
    }

    public BankAccount createBankAccount(Customer customer, double balance) {
        return new BankAccount(customer, balance, generator.generate());
    }
    public SaveAccount createSaveAccount(Customer customer, double balance, double interestRate) {
        return new SaveAccount(customer, balance, interestRate, generator.generate());
    }

    public StudentAccount createStudentAccount(Customer customer, double balance, String schoolName) {
        return new StudentAccount(customer, schoolName, generator.generate());
    }

}
