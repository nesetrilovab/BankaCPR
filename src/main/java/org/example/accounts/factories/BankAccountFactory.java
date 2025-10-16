package org.example.accounts.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.people.customers.Customer;

import java.util.UUID;

public class BankAccountFactory {

    private final BankAccountNumberGenerator generator = new BankAccountNumberGenerator();

    // Base account
    public BaseBankAccount createBaseAccount(Customer customer) {
        String uuid = UUID.randomUUID().toString();
        String accountNumber = generator.generate();
        return new BaseBankAccount(uuid, accountNumber, customer);
    }


    // Regular bank account
    public BankAccount createBankAccount(Customer customer, double balance) {
        String uuid = UUID.randomUUID().toString();
        String accountNumber = generator.generate();
        return new BankAccount(uuid, accountNumber, customer, balance);
    }

    // Savings account
    public SaveAccount createSaveAccount(Customer customer, double balance, double interestRate) {
        String uuid = UUID.randomUUID().toString();
        String accountNumber = generator.generate();
        return new SaveAccount(uuid, accountNumber, customer, balance, interestRate);
    }

    // Student account
    public StudentAccount createStudentAccount(Customer customer, double balance,String school) {
        String uuid = UUID.randomUUID().toString();
        String accountNumber = generator.generate();
        return new StudentAccount(uuid, accountNumber, customer, balance, school);
    }
}
