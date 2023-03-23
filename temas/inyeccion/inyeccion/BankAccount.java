package inyeccion;

import java.util.*;
import java.io.*;
import java.time.*;
import javax.inject.Inject;

public final class BankAccount implements Comparable<BankAccount> {
    // anadido IBankAccount
    private final String id;
    private final IBankAccount account;
    private LocalDate creationDate;
    private Comparator comparator;

    // cambiado
    @Inject
    public BankAccount(IBankAccount bankAccount) {
        this.id = bankAccount.getId();
        comparator = new BankAccountComparatorById();
    }
  

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate date) {
        this.creationDate = date;
    }

    // cambiado
    public String getId() {
        return account.getId();
    }

    public void setComparator(Comparator cmp) {
        comparator = cmp;
    }

    @Override
    public int compareTo(BankAccount other) {
        if (this == other)
        return 0;
        assert this.equals(other) : "compareTo inconsistent with equals.";
        return comparator.compare(this, other);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
        return true;
        if (!(other instanceof BankAccount))
        return false;
        BankAccount that = (BankAccount) other;
        return this.id.equals(that.getId());
    }

    @Override
    public String toString() {
        return id.toString();
    }
}