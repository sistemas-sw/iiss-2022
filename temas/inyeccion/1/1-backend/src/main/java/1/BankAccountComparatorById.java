
public class BankAccountComparatorById implements BankAccountComparator {
    @Override
    public int compare(BankAccount a, BankAccount b) {
        return a.getId().compareTo(b.getId());
    }
}
