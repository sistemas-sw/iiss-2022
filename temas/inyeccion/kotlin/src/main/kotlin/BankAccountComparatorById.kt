internal class BankAccountComparatorById : Comparator<BankAccount> {
    override fun compare(o1: BankAccount, o2: BankAccount): Int {
        return o1.id.compareTo(o2.id)
    }
}