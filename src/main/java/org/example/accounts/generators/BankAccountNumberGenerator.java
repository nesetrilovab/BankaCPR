package org.example.accounts.generators;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.Random;
@Singleton
public class BankAccountNumberGenerator {
    @Inject
    private final int accountNumberLength = 10;
    private final int bankNumberLength = 4;
    public final Random random;

    public BankAccountNumberGenerator() {
        this.random = new Random();
    }

    public String generate() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < accountNumberLength; i++) {
            sb.append(random.nextInt(10));
        }

        sb.append('/');

        for (int i = 0; i < bankNumberLength; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
