package org.example.accounts;

import org.example.cards.Card;
import org.example.people.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends CardHolder{
    private List<Card> cards = new ArrayList<>();

    public BankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
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
