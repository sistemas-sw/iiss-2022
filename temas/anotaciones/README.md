# Anotaciones en Java

He implementado el ejemplo de BankAccount usando los mecanismos de anotaciones de Java para inyectar como dependencia el comparador a usar. He usado anotaciones a medida para inyección de dependencias en runtime, según el JSR 330.

La anotación personalizada @comparator se utiliza para indicar qué implementación concreta de la interfaz Comparator debe ser utilizada para comparar las instancias de la clase BankAccount, ya que podría ser BankAccountComparatorById, o BankAcccountComparatorByCreationDate que también está incluida en el ejemplo, o cualquier otra que queramos implementar en el futuro. Ésto permite la inyección de dependencias en tiempo de ejecución

La clase BankAccount depende de la interfaz Comparator, ya que la utiliza para comparar las cuentas de banco . BankAccount no puede crear una instancia de un comparador en su propio constructor, lo que hace es utilizar la anotación personalizada @ComparatorType para indicar qué implementación concreta de Comparator debe utilizarse en tiempo de ejecución. Cuando se crea una instancia de la clase BankAccount, se crea también una instancia del comparador concreto especificado en la anotación @ComparatorType, la cual se inyecta en el campo comparator de la instancia de BankAccount. 

## Comparator.java

+ He definido la anotación con la interfaz @interface.


```java
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD })
public @interface Comparator
{
  String value();
}
```

## BankAccount.java

+ He agregado la anotacion personalizada al atributo comparator con @comparator("com.example.BankAccountComparatorById").
+ En el constructor, el objeto BankAccount se construye con un id que es el identificador que se usa para saber si dos cuentas de banco son iguales. Al construirlo, al atributo comparator le asigno un objeto de la clase BankAccountComparatorById.
+ Se usa la anotación @comparator para especificar qué implementación del comparador debe usarse para inyectar la dependencia en tiempo de ejecución. En este caso, la implementación concreta es "com.example.BankAccountComparatorById".
+ He agregado el tipo de parámetro <BankAccount> al comparador Comparator y al método setComparator, para que coincida con el tipo de BankAccount.

```java
public final class BankAccount implements Comparable<BankAccount> {
  private final String id;
  private LocalDate creationDate;

  @comparator("com.example.BankAccountComparatorById")
  private Comparator<BankAccount> comparator;

  public BankAccount(String number) {
    this.id = number;
    comparator = new BankAccountComparatorById();
  }
```

```java
public void setComparator(Comparator<BankAccount> cmp) {
    comparator = cmp;
}
```