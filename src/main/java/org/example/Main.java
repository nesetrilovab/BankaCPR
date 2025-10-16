package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.accounts.BankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.BankAccountService;
import org.example.cards.Card;
import org.example.cards.CardFactory;
import org.example.cards.LinkToBankAccountService;
import org.example.people.customers.Customer;
import org.example.people.customers.factories.CustomerFactory;
import org.example.people.customers.factories.CustomerSerializationFactory;
import org.example.people.customers.serialization.CustomerXmlSerialization;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        /*Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
            }
        });
        App app = injector.getInstance(App.class);
        app.run();*/
        Customer alice = CustomerFactory.createCustomer("Alice", "Johnson");
        Customer bob = CustomerFactory.createCustomer("Bob", "Smith");
        Customer charlie = CustomerFactory.createCustomer("Charlie", "Brown");


        BankAccountService accountService = new BankAccountService();
        CustomerSerializationFactory customerSerializationFactory = new CustomerSerializationFactory();





        BankAccountFactory accountFactory = new BankAccountFactory();
        BankAccount aliceAccount = accountFactory.createBankAccount(alice);
        SaveAccount bobSavings = accountFactory.createSaveAccount(bob, 2.5);
        StudentAccount charlieStudentAcc = accountFactory.createStudentAccount(charlie, "Oxford University");


        System.out.println("Alice -> " + aliceAccount.getBankAccountNumber());
        System.out.println("Bob -> " + bobSavings.getBankAccountNumber());
        System.out.println("Charlie -> " + charlieStudentAcc.getBankAccountNumber());
        System.out.println();
        CardFactory cardFactory = new CardFactory();

        Card aliceCard1 = cardFactory.createCard("12", "2028", "123", "Alice Johnson");
        Card aliceCard2 = cardFactory.createCard("06", "2029", "456", "Alice Johnson");
        Card charlieCard = cardFactory.createCard("09", "2027", "789", "Charlie Brown");

        LinkToBankAccountService linker = new LinkToBankAccountService();

        linker.linkCardToAccount(aliceAccount, aliceCard1);
        linker.linkCardToAccount(aliceAccount, aliceCard2);
        linker.linkCardToAccount(charlieStudentAcc, charlieCard);
        System.out.println("\n Cards linked to Alice's account:");
        aliceAccount.getCards().forEach(c -> System.out.println(" - " + c.getCardNumber()));

        System.out.println("\n Cards linked to Charlie's student account:");
        charlieStudentAcc.getCards().forEach(c -> System.out.println(" - " + c.getCardNumber()));
        CustomerXmlSerialization customerSerialization = customerSerializationFactory.create();

        System.out.println("\n Verification:");
        System.out.println("Alice UUID: " + alice.getUuid());
        System.out.println("Bob UUID: " + bob.getUuid());
        System.out.println("Charlie UUID: " + charlie.getUuid());
        System.out.println("Alice Balance: " + aliceAccount.getBalance());

        String serializedString = customerSerialization.serialize(alice);

        System.out.println("Customer serialized: " + serializedString);

        Customer reserializedCustomer = customerSerialization.deserialize(serializedString);
        System.out.println("Customer deserialized: " + reserializedCustomer.getUuid());
    }
}
