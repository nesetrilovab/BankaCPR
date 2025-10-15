package org.example.cards;

public class CardFactory {

        public Card createCard(String expirationMonth, String expirationYear, String cvc, String owner) {
            CardNumberGenerator generator = new CardNumberGenerator();
            String cardNumber = generator.generate();


            return new Card(cardNumber, expirationMonth, expirationYear, cvc, owner);
        }
}
