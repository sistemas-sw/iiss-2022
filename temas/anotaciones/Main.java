import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123");
        BankAccount account2 = new BankAccount("456");

        account1.setCreationDate(LocalDate.of(2022, 3, 27));
        account2.setCreationDate(LocalDate.of(2021, 1, 1));

        System.out.println("account1: " + account1);
        System.out.println("account2: " + account2);

        // Comparing two BankAccount objects using the ComparatorInterface implementation
        // specified by the @Comparator annotation in the BankAccount class
        int result = account1.compareTo(account2);

        if (result < 0) {
            System.out.println("account1 is less than account2");
        } else if (result > 0) {
            System.out.println("account1 is greater than account2");
        } else {
            System.out.println("account1 is equal to account2");
        }
    }
}

