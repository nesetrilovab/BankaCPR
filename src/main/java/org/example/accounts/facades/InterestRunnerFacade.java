package org.example.accounts.facades;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.services.InterestCalculatorService;

import java.time.LocalDate;
import java.util.List;

public class InterestRunnerFacade {

    private final InterestCalculatorService interestCalculator;

    public InterestRunnerFacade(InterestCalculatorService interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public void processAllInterest(List<BaseBankAccount> allAccounts) {
        for (BaseBankAccount account : allAccounts) {
            if (account instanceof SaveAccount saveAccount) {
                double interest = interestCalculator.calculate(saveAccount);
                saveAccount.setBalance(saveAccount.getBalance() + interest);
                saveAccount.setLastInterestDate(LocalDate.now());
                saveAccount.setNextInterestDate(LocalDate.now().plusMonths(1)); // pokud je interest calculating kazdej mesic

                System.out.println("Applied interest " + interest + " to " + saveAccount.getBankAccountNumber());
            }
        }
    }
}
