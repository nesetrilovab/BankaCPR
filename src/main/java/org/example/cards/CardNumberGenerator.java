package org.example.cards;

import java.util.Random;

public class CardNumberGenerator {
    private final int cardNumberLength = 16;

    public final Random random;

    public CardNumberGenerator() {
        this.random = new Random();
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cardNumberLength; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
