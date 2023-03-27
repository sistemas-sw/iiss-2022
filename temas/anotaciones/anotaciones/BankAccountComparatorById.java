package anotaciones;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class BankAccountComparatorById implements ComparatorInterface {

  @Override
  public int compare(BankAccount bankAccount, BankAccount other) {
      return bankAccount.getId().compareTo(other.getId());
  }
}