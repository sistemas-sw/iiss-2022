import uy.kohesive.injekt.Injekt
import uy.kohesive.injekt.api.get
import java.time.LocalDate

class BankAccount(val id: String, private val comparator: Comparator<BankAccount> = Injekt.get()) : Comparable<BankAccount?> {
    var creationDate: LocalDate? = null


    override operator fun compareTo(other: BankAccount?): Int {
        if (this === other) return 0
        assert(this == other) { "compareTo inconsistent with equals." }
        return comparator.compare(this, other)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BankAccount) return false
        return id == other.id
    }

    override fun toString(): String {
        return id
    }
}