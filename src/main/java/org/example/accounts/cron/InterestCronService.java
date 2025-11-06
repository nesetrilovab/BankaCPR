package org.example.accounts.cron;

import org.example.accounts.facades.InterestRunnerFacade;
import org.example.accounts.BaseBankAccount;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class InterestCronService {

    private final InterestRunnerFacade interestRunnerFacade;
    private final List<BaseBankAccount> accounts;

    public InterestCronService(InterestRunnerFacade interestRunnerFacade, List<BaseBankAccount> accounts) {
        this.interestRunnerFacade = interestRunnerFacade;
        this.accounts = accounts;
    }

    public void start() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                interestRunnerFacade.processAllInterest(accounts);
            }
        }, 0, 60 * 1000); //kazdou minutu
    }
}
