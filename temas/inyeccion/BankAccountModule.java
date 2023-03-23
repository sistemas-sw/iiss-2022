import com.google.inject.AbstractModule;

public class BankAccountModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(BankAccountComparatorById.class);
  }
}

