package org.example.accounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BaseBankAccount;
@Singleton
public class CheckDepositLimitService {
    @Inject
    private static final double max = 10000;

    public void checkDeposit(BaseBankAccount account, double amount) {
        if (amount > max) {
            throw new IllegalArgumentException(
                    "Deposit exceeds limit of €" + max + ". Possible money laundering!"
            );
        }
    }
}
