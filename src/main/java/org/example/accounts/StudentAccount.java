package org.example.accounts;

import org.example.people.customers.Customer;

public class StudentAccount extends BaseBankAccount {
    private String school;


    public StudentAccount(Customer customer, String school) {
        super(customer); // balance na 0
        this.school = school;
    }


    public StudentAccount(Customer customer) {
        super(customer);
    }

    // Getter a Setter
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
