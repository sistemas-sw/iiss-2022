import uy.kohesive.injekt.*
import uy.kohesive.injekt.api.*
import java.time.LocalDate


class Main {
    companion object : InjektMain() {
        @JvmStatic fun main(args: Array<String>) {
            Main().run()
        }

        override fun InjektRegistrar.registerInjectables() {

            val comparator : Comparator<BankAccount> = BankAccountComparatorByCreationDate()
            addSingleton(comparator)
        }
    }

    fun run() {
        val date = LocalDate.of(2020, 1, 1)
        val bankAccount = BankAccount("123")
        bankAccount.creationDate = date

        val date2 = LocalDate.of(2022, 1, 2)
        val bankAccount2 = BankAccount("011")
        bankAccount2.creationDate = date2
        println(bankAccount.compareTo(bankAccount2))

    }
}