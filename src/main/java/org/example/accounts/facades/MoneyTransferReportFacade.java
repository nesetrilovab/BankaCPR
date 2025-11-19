package org.example.accounts.facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.MoneyTransfer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class MoneyTransferReportFacade {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void processAllTransfers(List<BaseBankAccount> allAccounts) {
        try {
            File outputFile = new File("money_transfers_report.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, allAccounts);
            System.out.println("Money transfers saved to " + outputFile.getAbsolutePath());


            for (BaseBankAccount acc : allAccounts) {
                acc.getTransfers().forEach(MoneyTransfer::markAsTransferred);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error writing transfer report", e);
        }
    }

}
