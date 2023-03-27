public class BankAccountComparatorById implements ComparatorInterface {
  @Override
  public int compare(BankAccount bankAccount, BankAccount other) {
      return bankAccount.getId().compareTo(other.getId());
  }
}
