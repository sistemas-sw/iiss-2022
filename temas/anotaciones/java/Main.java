import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("123");
        if (BankAccount.class.isAnnotationPresent(comparator.class)) {
            var cmpAnnotation = BankAccount.class.getAnnotation(comparator.class).compare();

            try {
                Comparator<BankAccount> comp = cmpAnnotation.getDeclaredConstructor().newInstance();
                bankAccount.setComparator(comp);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    
    }
}
