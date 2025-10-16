package org.example.accounts;

import org.example.cards.Card;
import org.example.people.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class StudentAccount extends CardHolder{
    private String school;

    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, double balance, String school) {
        super(uuid, bankAccountNumber, customer, balance);
        this.school = school;
    }




    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    @Override
    public void addCard(Card card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }
    @Override
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

}
