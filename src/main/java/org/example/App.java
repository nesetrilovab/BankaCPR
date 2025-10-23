package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.transactions.TransactionLogger;
import org.example.cards.Card;
import org.example.cards.CardFactory;
import org.example.cards.LinkToBankAccountService;
import org.example.accounts.services.BankAccountService;
import org.example.people.customers.Customer;
import org.example.people.customers.factories.CustomerFactory;
import org.example.people.customers.serialization.CustomerXmlSerialization;
import org.example.people.customers.factories.CustomerSerializationFactory;

import java.awt.*;

public class App {
    @Inject @Deprecated
    Container container;
    @Inject
    private CustomerFactory customerFactory;
    @Inject
    private BankAccountFactory bankAccountFactory;
    @Inject
    private CardFactory cardFactory;
    @Inject
    private BankAccountService bankAccountService;
    @Inject
    private CustomerSerializationFactory customerSerializationFactory;
    @Inject
    private TransactionLogger transactionLogger;

    public void run() throws JsonProcessingException {


        Container container = new Container();


        CustomerFactory customerFactory = this.customerFactory;
        BankAccountFactory accountFactory = this.bankAccountFactory;
        CardFactory cardFactory = this.cardFactory;
        BankAccountService accountService = this.bankAccountService;
        CustomerSerializationFactory customerSerializationFactory = this.customerSerializationFactory;


        // --- Create customers ---
        Customer alice = customerFactory.createCustomer("Alice", "Johnson");
        Customer bob = customerFactory.createCustomer("Bob", "Smith");
        Customer charlie = customerFactory.createCustomer("Charlie", "Brown");

        // --- Create accounts ---
        BankAccount aliceAccount = accountFactory.createBankAccount(alice);
        SaveAccount bobSavings = accountFactory.createSaveAccount(bob, 2.5);
        StudentAccount charlieStudentAcc = accountFactory.createStudentAccount(charlie, "Oxford University");

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
    }
}
