package org.example.accounts.cron;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.facades.MoneyTransferReportFacade;

public class MoneyTransferCronService {

    private final MoneyTransferReportFacade reportFacade;
    private final List<BaseBankAccount> allAccounts;

    public MoneyTransferCronService(MoneyTransferReportFacade reportFacade, List<BaseBankAccount> allAccounts) {
        this.reportFacade = reportFacade;
        this.allAccounts = allAccounts;
    }

    public void start() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            reportFacade.processAllTransfers(allAccounts);
        }, 0, 1, TimeUnit.DAYS);
    }
}
