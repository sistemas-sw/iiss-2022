public class BankAccountComparatorByCreationDate implements ComparatorInterface {
    @Override
    public int compare(BankAccount bankAccount, BankAccount other) {
        return bankAccount.getCreationDate().compareTo(other.getCreationDate());
    }
}
