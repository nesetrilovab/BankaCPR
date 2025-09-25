package org.example;

import org.example.accounts.*;
import org.example.people.customers.Customer;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("c-001", "Barbora", "Nesetrilova");
        Customer customer2 = new Customer("c-002", "Katerina", "Vaicova");


        SaveAccount barboraSave = new SaveAccount(customer1, 5);


        StudentAccount katerinaStudent = new StudentAccount(customer2, "DELTA SSIE");


        barboraSave.deposit(1000);
        System.out.println("Barbora's balance after deposit: " + barboraSave.getBalance());


        barboraSave.applyInterest();
        System.out.println("Barbora's balance after applying interest: " + barboraSave.getBalance());


        barboraSave.withdraw(200);
        System.out.println("Barbora's balance after withdrawal: " + barboraSave.getBalance());


        katerinaStudent.deposit(500);
        System.out.println("Katerina's balance after deposit: " + katerinaStudent.getBalance());


        katerinaStudent.withdraw(100);
        System.out.println("Katerina's balance after withdrawal: " + katerinaStudent.getBalance());


        System.out.println("Katerina's school: " + katerinaStudent.getSchool());
        System.out.println("Barbora's interest rate: " + barboraSave.getInterestRate() + "%");
    }
}
