package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import org.example.accounts.*;
import org.example.accounts.facades.InterestRunnerFacade;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.BankAccountService;
import org.example.accounts.services.DepositService;
import org.example.accounts.services.WithdrawService;
import org.example.accounts.cron.InterestCronService;
import org.example.accounts.transactions.TransactionLogger;
import org.example.cards.*;
import org.example.people.customers.Customer;
import org.example.people.customers.factories.CustomerFactory;
import org.example.people.customers.factories.CustomerSerializationFactory;
import org.example.people.customers.serialization.CustomerXmlSerialization;

import java.util.List;

public class App {

    @Inject private CustomerFactory customerFactory;
    @Inject private BankAccountFactory bankAccountFactory;
    @Inject private CardFactory cardFactory;
    @Inject private BankAccountService bankAccountService;
    @Inject private CustomerSerializationFactory customerSerializationFactory;
    @Inject private TransactionLogger transactionLogger;
    @Inject private InterestRunnerFacade interestRunnerFacade;
    @Inject private InterestCronService interestCronService;
    @Inject private DepositService depositService;
    @Inject private WithdrawService withdrawService;

    public void run() throws JsonProcessingException {

        // --- Create customers ---
        Customer alice = customerFactory.createCustomer("Alice", "Johnson");
        Customer bob = customerFactory.createCustomer("Bob", "Smith");
        Customer charlie = customerFactory.createCustomer("Charlie", "Brown");

        // --- Create accounts ---
        BankAccount aliceAccount = bankAccountFactory.createBankAccount(alice);
        SaveAccount bobSavings = bankAccountFactory.createSaveAccount(bob, 2.5);
        StudentAccount charlieStudentAcc = bankAccountFactory.createStudentAccount(charlie, "Oxford University");

        // --- Deposits (add MoneyTransfer automatically) ---
        depositService.depositCash(aliceAccount, 1000.0);
        depositService.depositCash(bobSavings, 5000.0);
        depositService.depositCash(charlieStudentAcc, 300.0);

        // --- Withdrawals (add MoneyTransfer automatically) ---
        withdrawService.withdrawCash(aliceAccount, 200.0);
        withdrawService.withdrawCash(bobSavings, 1000.0);

        // --- Print balances and transfers ---
        System.out.println("=== Account balances and transfers ===");
        System.out.println(alice.getUuid() + " balance: " + aliceAccount.getBalance() + ", transfers: " + aliceAccount.getTransfers());
        System.out.println(bob.getUuid() + " balance: " + bobSavings.getBalance() + ", transfers: " + bobSavings.getTransfers());
        System.out.println(charlie.getUuid() + " balance: " + charlieStudentAcc.getBalance() + ", transfers: " + charlieStudentAcc.getTransfers());

        // --- Cards ---
        Card aliceCard1 = cardFactory.createCard("12", "2028", "123", "Alice Johnson");
        Card aliceCard2 = cardFactory.createCard("06", "2029", "456", "Alice Johnson");
        Card charlieCard = cardFactory.createCard("09", "2027", "789", "Charlie Brown");

        LinkToBankAccountService linker = new LinkToBankAccountService();
        linker.linkCardToAccount(aliceAccount, aliceCard1);
        linker.linkCardToAccount(aliceAccount, aliceCard2);
        linker.linkCardToAccount(charlieStudentAcc, charlieCard);

        // --- Serialize a customer ---
        CustomerXmlSerialization customerSerialization = customerSerializationFactory.create();
        String serializedString = customerSerialization.serialize(alice);
        System.out.println("\nCustomer serialized: " + serializedString);
        Customer reserializedCustomer = customerSerialization.deserialize(serializedString);
        System.out.println("Customer deserialized: " + reserializedCustomer.getUuid());

        // --- Interest calculation ---
        System.out.println("\n=== Running Interest Calculation (manual) ===");
        interestRunnerFacade.processAllInterest(List.of(aliceAccount, bobSavings, charlieStudentAcc));

        // --- Start automatic interest cron ---
        System.out.println("\n=== Starting Interest Cron Service ===");
        interestCronService.start();
    }
}
