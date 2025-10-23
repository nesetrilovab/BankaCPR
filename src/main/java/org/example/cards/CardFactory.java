package org.example.cards;


import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CardFactory {
    @Inject
    private final CardNumberGenerator cardNumberGenerator;


    public CardFactory(CardNumberGenerator cardNumberGenerator) {
        this.cardNumberGenerator = cardNumberGenerator;
    }


    public Card createCard(String expirationMonth, String expirationYear, String cvc, String owner) {

        String cardNumber = cardNumberGenerator.generate();

        return new Card(cardNumber, expirationMonth, expirationYear, cvc, owner);
    }
}

