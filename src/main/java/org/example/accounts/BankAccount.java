package org.example.accounts;

import org.example.cards.Card;
import org.example.people.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends CardHolder{
    private List<Card> cards = new ArrayList<>();

    public BankAccount(String bankAccountNumber, Customer customer) {
        super(bankAccountNumber, customer);
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
