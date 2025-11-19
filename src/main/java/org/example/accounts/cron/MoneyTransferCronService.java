package org.example.accounts.cron;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.facades.MoneyTransferReportFacade;

public class MoneyTransferCronService {

    private final MoneyTransferReportFacade reportFacade;
    private final List<BaseBankAccount> allAccounts;
    private final ScheduledExecutorService scheduler;

    public MoneyTransferCronService(MoneyTransferReportFacade reportFacade, List<BaseBankAccount> allAccounts) {
        this.reportFacade = reportFacade;
        this.allAccounts = allAccounts;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() {
        scheduler.scheduleAtFixedRate(() -> {
            reportFacade.processAllTransfers(allAccounts);
        }, 0, 1, TimeUnit.DAYS);
    }

    public void stop() {
        scheduler.shutdown();
    }
}
