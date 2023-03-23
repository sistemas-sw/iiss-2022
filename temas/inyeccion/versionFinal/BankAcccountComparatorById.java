package versionFinal;
import BankAccount;

import java.util.*;
import com.google.inject.Inject;

package versionFinal;

class BankAccountComparatorById implements Comparator<BankAccount> {
    // cambiado
    @Inject
    public BankAccountComparatorById() {
    }
    
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
