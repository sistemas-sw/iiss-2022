# Anotaciones en Java

He implementado el ejemplo de BankAccount usando los mecanismos de anotaciones de Java para inyectar como dependencia el comparador a usar. He usado anotaciones a medida para inyección de dependencias en runtime, según el JSR 330.

La anotación personalizada @Comparator se utiliza para indicar qué implementación concreta de la interfaz Comparator debe ser utilizada para comparar las instancias de la clase BankAccount, ya que podría ser BankAccountComparatorById, o BankAcccountComparatorByCreationDate que también está incluida en el ejemplo original, o cualquier otra que queramos implementar en el futuro. Ésto permite la inyección de dependencias en tiempo de ejecución.

## Comparator.java

+ He definido la anotación con la interfaz @interface.


```java
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD })
public @interface Comparator {
    Class<? extends ComparatorInterface> value() default BankAccountComparatorById.class;
}
```

## BankAccount.java

BankAccount que representa una cuenta bancaria con un identificador único y una fecha de creación. La clase implementa la interfaz Comparable, lo que significa que se puede comparar una instancia de BankAccount con otra instancia de la misma clase.

La clase también define una anotación @Comparator que se utiliza para especificar qué implementación de ComparatorInterface debe utilizarse para comparar las instancias de BankAccount.

+ He agregado la anotacion personalizada al atributo comparator con @Comparator (BankAccountComparatorByCreationDate.class) private ComparatorInterface comparator;;
+ En el constructor, el objeto BankAccount se construye con un id que es el identificador que se usa para saber si dos cuentas de banco son iguales.
+ Se usa la anotación @Comparator para especificar qué implementación del comparador debe usarse para inyectar la dependencia en tiempo de ejecución. En este caso, la implementación concreta es BankAccountComparatorById.

```java
public final class BankAccount implements Comparable<BankAccount> {
  private final String id;
  private LocalDate creationDate;

  @Comparator(BankAccountComparatorByCreationDate.class)
  private ComparatorInterface comparator;

  public BankAccount(String number) {
    this.id = number;
  }
  //...
}
```

```java
public void setComparator(ComparatorInterface cmp) {
    comparator = cmp;
}
```

## ComparatorInterface.java

+ La interfaz ComparatorInterface define un método compare() que se utiliza para comparar dos instancias de BankAccount.

```java
public interface ComparatorInterface {
    public int compare(BankAccount bankAccount, BankAccount other);
}
```

## BankAccountComparatorById.java

+ La clase BankAccountComparatorById es una implementación de ComparatorInterface que compara dos instancias de BankAccount basándose en sus identificadores.

```java
public class BankAccountComparatorById implements ComparatorInterface {
  @Override
  public int compare(BankAccount bankAccount, BankAccount other) {
      return bankAccount.getId().compareTo(other.getId());
  }
}
```

## BankAccountComparatorByCreationDate
+ La clase BankAccountComparatorByCreationDate es una implementación de ComparatorInterface que compara dos instancias de BankAccount basándose en sus fechas de creación.

```java
public class BankAccountComparatorByCreationDate implements ComparatorInterface {
  @Override
  public int compare(BankAccount bankAccount, BankAccount other) {
      return bankAccount.getCreationDate().compareTo(other.getCreationDate());
  }
}

```


## Main.java

La clase Main contiene un método main que crea dos objetos de BankAccount y las compara utilizando el método compareTo(). La implementación de ComparatorInterface utilizada para la comparación se inyecta y el resultado de la comparación se imprime en la consola.

```java
// Inyectar un comparador diferente a BankAccountComparatorById
account1.setComparator(new BankAccountComparatorByCreationDate());

// Comparing two BankAccount objects using the ComparatorInterface implementation
int result = account1.compareTo(account2);

// Changing the comparator to BankAccountComparatorById
account1.setComparator(new BankAccountComparatorById());
result = account1.compareTo(account2);
```

# Compilar y ejecutar

Compilar:
```console
javac Main.java BankAccount.java BankAccountComparatorById.java ComparatorInterface.java Comparator.java
```

Ejecutar:
```console
java Main
```

Resultado de ejecutar:
```console
account1: 123 2022-03-27
account2: 456 2021-01-01
By creation date: account1 is greater than account2
By id: account1 is less than account2
```
