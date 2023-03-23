package versionFinal;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
        BankAccountComparatorById comparator = injector.getInstance(BankAccountComparatorById.class);
        
        // Use the comparator.
        BankAccount account1 = new BankAccount("123");
        BankAccount account2 = new BankAccount("456");
        int result = comparator.compare(account1, account2);
    }
}

