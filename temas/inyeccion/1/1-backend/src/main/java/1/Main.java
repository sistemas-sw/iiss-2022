
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankAccountModule());
        BankAccount account1 = injector.getInstance(BankAccount.class);
        BankAccount account2 = injector.getInstance(BankAccount.class);

        // Configurar los atributos de las cuentas bancarias
        account1.setId("123");
        account2.setId("456");
        account1.setCreationDate(LocalDate.of(2022, 1, 1));
        account2.setCreationDate(LocalDate.of(2022, 2, 1));

        // Comparar las cuentas bancarias
        int result = account1.compareTo(account2);
        System.out.println("El resultado de la comparación es: " + result);
    }
}
