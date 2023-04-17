internal class BankAccountComparatorByCreationDate : Comparator<BankAccount> {
    override fun compare(o1: BankAccount, o2: BankAccount): Int {
        return o1.creationDate!!.compareTo(o2.creationDate)
    }
}