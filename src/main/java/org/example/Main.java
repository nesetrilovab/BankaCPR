package org.example;

import org.example.accounts.*;
import org.example.people.customers.Customer;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("c-001", "Barbora", "Nesetrilova");
        Customer customer2 = new Customer("c-002", "Katerina", "Vaicova");


        SaveAccount barboraSave = new SaveAccount("a-001", "1234567890", customer1, 5.0f);


        StudentAccount katerinaStudent = new StudentAccount("a-002", "9876543210", customer2, "DELTA SSIE");


        barboraSave.addBalance(1000.0);
        System.out.println("Barbora's balance after deposit: " + barboraSave.getBalance());


        barboraSave.applyInterest();
        System.out.println("Barbora's balance after applying interest: " + barboraSave.getBalance());


        barboraSave.subBalance(200.0);
        System.out.println("Barbora's balance after withdrawal: " + barboraSave.getBalance());


        katerinaStudent.addBalance(500.0);
        System.out.println("Katerina's balance after deposit: " + katerinaStudent.getBalance());


        katerinaStudent.subBalance(100.0);
        System.out.println("Katerina's balance after withdrawal: " + katerinaStudent.getBalance());


        System.out.println("Katerina's school: " + katerinaStudent.getSchool());
        System.out.println("Barbora's interest rate: " + barboraSave.getInterestRate() + "%");
    }
}
