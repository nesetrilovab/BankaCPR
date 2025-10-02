package org.example.accounts.services;

import org.example.accounts.BaseBankAccount;

public class CheckDepositLimitService {
    private static final double max = 10000;

    public void checkDeposit(BaseBankAccount account, double amount) {
        if (amount > max) {
            throw new IllegalArgumentException(
                    "Deposit exceeds limit of €" + max + ". Possible money laundering!"
            );
        }
    }
}
