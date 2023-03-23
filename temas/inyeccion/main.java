import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new BankAccountModule());
    BankAccount account = injector.getInstance(BankAccount.class);
  }
}
