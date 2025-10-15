package org.example.cards;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.CardHolder;

public class LinkToBankAccountService {

    public void linkCardToAccount(BaseBankAccount account, Card card) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null.");
        }

        if (!(account instanceof CardHolder)) {
            throw new IllegalArgumentException("This account type cannot have cards.");
        }

        // If the card already belongs to another account
        if (card.getLinkedAccount() != null) {
            throw new IllegalArgumentException("This card is already linked to another account.");
        }

        CardHolder cardHolder = (CardHolder) account;

        if (!cardHolder.getCards().contains(card)) {
            cardHolder.addCard(card);
            card.linkToAccount(account);
            System.out.println("Card " + card.getCardNumber() + " linked to account " + account.getBankAccountNumber());
        } else {
            System.out.println("Card is already linked to this account.");
        }
    }
}
