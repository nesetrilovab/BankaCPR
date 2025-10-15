package org.example.accounts;

import org.example.cards.Card;
import org.example.people.customers.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public abstract class CardHolder extends BaseBankAccount {

    public List<Card> cards = new ArrayList<>();

    public CardHolder(String uuid, String bankAccountNumber, Customer customer) {
        super(uuid, bankAccountNumber, customer, 0.0);
    }


    public void addCard(Card card) {
        if (card == null) throw new IllegalArgumentException("Card cannot be null.");

        if (!cards.contains(card)) {
            cards.add(card);
            System.out.println("Card " + card.getCardNumber() + " added to account " + getBankAccountNumber());
        }
    }


    public List<Card> getCards() {
        return new ArrayList<>(cards); // simpler than unmodifiableList
    }
}
