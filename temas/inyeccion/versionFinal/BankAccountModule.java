package versionFinal;

import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    // Bind IBankAccount to BankAccount.
    bind(IBankAccount.class).to(BankAccount.class);
    
    // Bind BankAccountComparatorById.
    bind(BankAccountComparatorById.class);
  }
}
