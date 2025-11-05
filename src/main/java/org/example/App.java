package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.BankAccountService;
import org.example.accounts.cron.InterestCronService;
import org.example.accounts.facades.InterestRunnerFacade;
import org.example.accounts.transactions.TransactionLogger;
import org.example.cards.Card;
import org.example.cards.CardFactory;
import org.example.cards.LinkToBankAccountService;
import org.example.people.customers.Customer;
import org.example.people.customers.factories.CustomerFactory;
import org.example.people.customers.factories.CustomerSerializationFactory;
import org.example.people.customers.serialization.CustomerXmlSerialization;

import java.util.List;

public class App {

    // Dependency injection
    @Inject private CustomerFactory customerFactory;
    @Inject private BankAccountFactory bankAccountFactory;
    @Inject private CardFactory cardFactory;
    @Inject private BankAccountService bankAccountService;
    @Inject private CustomerSerializationFactory customerSerializationFactory;
    @Inject private TransactionLogger transactionLogger;
    @Inject private InterestRunnerFacade interestRunnerFacade;
    @Inject private InterestCronService interestCronService;

    public void run() throws JsonProcessingException {

        // --- Create customers ---
        Customer alice = customerFactory.createCustomer("Alice", "Johnson");
        Customer bob = customerFactory.createCustomer("Bob", "Smith");
        Customer charlie = customerFactory.createCustomer("Charlie", "Brown");

        // --- Create accounts ---
        BankAccount aliceAccount = bankAccountFactory.createBankAccount(alice);
        SaveAccount bobSavings = bankAccountFactory.createSaveAccount(bob, 2.5);
        StudentAccount charlieStudentAcc = bankAccountFactory.createStudentAccount(charlie, "Oxford University");

        System.out.println("Alice -> " + aliceAccount.getBankAccountNumber());
        System.out.println("Bob -> " + bobSavings.getBankAccountNumber());
        System.out.println("Charlie -> " + charlieStudentAcc.getBankAccountNumber());
        System.out.println();

        // --- Create cards ---
        Card aliceCard1 = cardFactory.createCard("12", "2028", "123", "Alice Johnson");
        Card aliceCard2 = cardFactory.createCard("06", "2029", "456", "Alice Johnson");
        Card charlieCard = cardFactory.createCard("09", "2027", "789", "Charlie Brown");

        // --- Link cards to accounts ---
        LinkToBankAccountService linker = new LinkToBankAccountService();
        linker.linkCardToAccount(aliceAccount, aliceCard1);
        linker.linkCardToAccount(aliceAccount, aliceCard2);
        linker.linkCardToAccount(charlieStudentAcc, charlieCard);

        System.out.println("\nCards linked to Alice's account:");
        aliceAccount.getCards().forEach(c -> System.out.println(" - " + c.getCardNumber()));

        System.out.println("\nCards linked to Charlie's student account:");
        charlieStudentAcc.getCards().forEach(c -> System.out.println(" - " + c.getCardNumber()));

        // --- Serialize customer ---
        CustomerXmlSerialization customerSerialization = customerSerializationFactory.create();
        String serializedString = customerSerialization.serialize(alice);
        System.out.println("\nCustomer serialized: " + serializedString);

        Customer reserializedCustomer = customerSerialization.deserialize(serializedString);
        System.out.println("Customer deserialized: " + reserializedCustomer.getUuid());

        // --- Verification ---
        System.out.println("\nVerification:");
        System.out.println("Alice UUID: " + alice.getUuid());
        System.out.println("Bob UUID: " + bob.getUuid());
        System.out.println("Charlie UUID: " + charlie.getUuid());
        System.out.println("Alice Balance: " + aliceAccount.getBalance());

        // --- Interest logic ---
        System.out.println("\n=== Running Interest Calculation (manual) ===");
        interestRunnerFacade.processAllInterest(List.of(aliceAccount, bobSavings, charlieStudentAcc));

        // --- Start automatic cron process ---
        System.out.println("\n=== Starting Interest Cron Service (auto every minute) ===");
        interestCronService.start();
    }
}
