package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.serialization.CustomerGsonSerialization;
import org.example.accounts.serialization.CustomerSerializationFactory;
import org.example.accounts.services.BankAccountService;
import org.example.people.customers.Customer;

public class App {
    @Inject
    private CustomerSerializationFactory customerSerializationFactory;

    public void run() throws JsonProcessingException {
        // Create customers
        Customer customer1 = new Customer("c-001", "Barbora", "Nesetrilova");
        Customer customer2 = new Customer("c-002", "Katerina", "Vaicova");

        // Create factory and service
        BankAccountFactory accountFactory = new BankAccountFactory();
        BankAccountService accountService = new BankAccountService();

        // Create accounts via factory
        SaveAccount barboraSave = accountFactory.createSaveAccount(customer1, 0, 5); // 5% interest
        StudentAccount katerinaStudent = accountFactory.createStudentAccount(customer2, 0, "DELTA SSIE");

        // Deposit money using service
        accountService.deposit(barboraSave, 1000);
        System.out.println("Barbora's balance after deposit: " + barboraSave.getBalance());

        // Apply interest
        accountService.applyInterest(barboraSave);

        System.out.println("Barbora's balance after applying interest: " + barboraSave.getBalance());

        // Withdraw money using service
        accountService.withdraw(barboraSave, 200);
        System.out.println("Barbora's balance after withdrawal: " + barboraSave.getBalance());

        // Student account operations
        accountService.deposit(katerinaStudent, 500);
        System.out.println("Katerina's balance after deposit: " + katerinaStudent.getBalance());

        accountService.withdraw(katerinaStudent, 100);
        System.out.println("Katerina's balance after withdrawal: " + katerinaStudent.getBalance());

        try {
            accountService.deposit(barboraSave, 15000);
        } catch (IllegalArgumentException e) {
            System.out.println("Large deposit blocked: " + e.getMessage());
        }

        CustomerGsonSerialization customerSerialization = this.customerSerializationFactory.create();
        String serializedString = customerSerialization.serialize(customer1);

        System.out.println("Customer serialized: " + serializedString);

        Customer reserializedCustomer = customerSerialization.deserialize(serializedString);
        System.out.println("Customer deserialized: " + reserializedCustomer.getUuid());

        System.out.println("Katerina's school: " + katerinaStudent.getSchool());
        System.out.println("Barbora's interest rate: " + barboraSave.getInterestRate() + "%");
        System.out.println("Barbora's final balance: " + barboraSave.getBalance());
    }
}
