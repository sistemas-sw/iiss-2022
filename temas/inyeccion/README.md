
# Inyeccion de dependencias con Guice

Guice es un framework de inyección de dependencias para Java que permite la creación y gestión automática de objetos y sus dependencias. En la inyección de dependencias con Guice, se define cómo se crearán y gestionarán las instancias de las clases y sus dependencias.

La inyección de dependencias con Guice se basa en la idea de que las clases no deben crear o gestionar sus propias dependencias. En su lugar, estas dependencias se proporcionan a través de constructores, métodos o campos anotados con "@Inject". Guice se encarga de resolver estas dependencias y proporcionar las instancias adecuadas de los objetos.

El proceso de inyección de dependencias con Guice se realiza en tiempo de ejecución, lo que significa que las dependencias se pueden cambiar fácilmente sin tener que modificar el código fuente. Además, Guice proporciona un sistema de ámbito que permite controlar el ciclo de vida de las instancias de objetos y sus dependencias.

## BankAccountComparatorById

+ He añadido @Inject y he creado un constructor

```Java
class BankAccountComparatorById implements Comparator<BankAccount> {
    // cambiado
    @Inject
    public BankAccountComparatorById() {
    }
    
    public int compare(BankAccount o1, BankAccount o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
```

## BankAccountModule

+ He creado un modulo de Guice que proporcione una instancia de BankAccount a la clase BankAccountComparatorById.
+ El modulo hereda de AbstractModule, que es un modulo de Guice.
+ En Java, "bind" se refiere a la vinculación de un objeto o propiedad de un objeto a otro objeto o propiedad, lo que significa que cualquier cambio en el objeto o propiedad vinculado se reflejará en el objeto o propiedad que se vinculó.


```java
public class MyModule extends AbstractModule {
  @Override
  protected void configure() {
    // Bind IBankAccount to BankAccount.
    bind(IBankAccount.class).to(BankAccount.class);
    
    // Bind BankAccountComparatorById.
    bind(BankAccountComparatorById.class);
  }
}
```

## BankAccount

+ He añadido un atributo que es objeto IBankAccount.
+ En el constructor he cambiado que reciba un objeto IBankAccount.

```java
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

    /...
}
```

## IBankAccount

+ He creado una interfaz para BankAccount, IBankAccount.

```java
public interface IBankAccount {
    String getId();
}
```

## Main

+ He creado una clase main donde hay una instancia de Injector que use su método getInstance() para obtener una instancia de BankAccountComparatorById con la dependencia de BankAccount inyectada.
+ He creado dos objetos BankAccount y los comparo metiendo en una variable result si son o no iguales.

```java
public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
        BankAccountComparatorById comparator = injector.getInstance(BankAccountComparatorById.class);
        
        // Use the comparator.
        BankAccount account1 = new BankAccount("123");
        BankAccount account2 = new BankAccount("456");
        int result = comparator.compare(account1, account2);
    }
}
```
