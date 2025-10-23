package org.example.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;
@Singleton
public class CardNumberGenerator {
    @Inject
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
