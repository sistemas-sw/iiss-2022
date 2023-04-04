# Ejemplo

Este ejemplo de anotaciones en java consistirá en la implementación del ejemplo de `BankAccount`, haciendo uso de las anotaciones en java, para indicar que comparación se realizará.

En primer lugar tenemos que crear la anotación en cuestión.

comparator.java
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface comparator {
    Class<? extends Comparator<BankAccount>> compare();
}
```

Como podemos ver las anotaciones se declaran haciendo uso de la palabra clave `@interface`.

Con el uso de la anotación `@Retention` y el argumento `RetentionPolicy.RUNTIME`, indicamos que se trata de una anotación que existe en tiempo de ejecución.

Con la anotación `@Target` indicamos al tipo de elemento que se le puede aplicar esta anotación, usando el argumento `ElementType.TYPE`, establecemos que esta anotación se podrá aplicar a clases.

Dentro de la anotación podemos encontrar la expresión `Class<? extends Comparator<BankAccount>> compare();`

Es decir, la anotación recibe un argumento el cual es una clase que implementa la interfaz `Comparator<BankAccount>`.

Los comparadores que usaremos serán los siguientes.

BankAccountComaratorById.java

```java
import java.util.*;

class BankAccountComparatorById implements Comparator<BankAccount> {
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
```

BankAccountComparatorByCreationDate.java

```java
import java.util.*;

class BankAccountComparatorByCreationDate implements Comparator<BankAccount> {
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }
}
```

Ahora en BankAccount.java indirecaremos cual utilizar.

```java
import java.time.LocalDate;
import java.util.Comparator;

@comparator(compare = BankAccountComparatorById.class)
public final class BankAccount implements Comparable<BankAccount> {
  private final String id;
  private LocalDate creationDate;
  private Comparator<BankAccount> comparator;

  public BankAccount(String number) {
    this.id = number;
    comparator = new BankAccountComparatorById();   
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate date) {
    this.creationDate = date;
  }

  public String getId() {
    return id;
  }

  public void setComparator(Comparator<BankAccount> cmp) {
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
```

Ahora hace implementar la lógica de la anotación. Por simplificar la haremos en el Main.java

```java
import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 1, 1);
        BankAccount bankAccount = new BankAccount("123");
        bankAccount.setCreationDate(date);

        LocalDate date2 = LocalDate.of(2022, 1, 2);
        BankAccount bankAccount2 = new BankAccount("011");
        bankAccount2.setCreationDate(date2);
        
        if (BankAccount.class.isAnnotationPresent(comparator.class)) {
            var cmpAnnotation = BankAccount.class.getAnnotation(comparator.class).compare();

            try {
                Comparator<BankAccount> comp = cmpAnnotation.getDeclaredConstructor().newInstance();
                bankAccount.setComparator(comp);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(bankAccount.compareTo(bankAccount2));
    }
}
```

La programación de la anotación se consigue haciendo uso de `Java Reflection` que consiste en metaprogramar.

En primer lugar comprobamos si la clase tiene la anotación compare. En caso afirmativo obtenemos la clase que implementa la comparación a través de la linea `Comparator<BankAccount> comp = cmpAnnotation.getDeclaredConstructor().newInstance();`

Posteriormente hacemos set del comparador en cuestión.

## Ejecución

Para ejecutar el ejemplo ejecute los siguientes comandos.

`javac *.java`
`java Main`
