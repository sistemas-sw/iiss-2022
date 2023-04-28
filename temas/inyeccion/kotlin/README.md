# Inyección de dependencias

## Construcción

Para la construcción del software usaremos la herramienta maven. Debemos situarnos en la carpeta kotlin, donde se encuentra el pom.xml y ejecutamos:

```bash
mvn clean package
```

Posteriormente usamos el siguiente comando, para ejecutar la aplicación

```bash
mvn exec:java
```

## Ejemplo

Para la implementación de la inyección de dependencias en Kotlin usaremos la biblioteca injekt.

```kotlin
internal class BankAccountComparatorById : Comparator<BankAccount> {
    override fun compare(o1: BankAccount, o2: BankAccount): Int {
        return o1.id.compareTo(o2.id)
    }
}
```

```kotlin
internal class BankAccountComparatorById : Comparator<BankAccount> {
    override fun compare(o1: BankAccount, o2: BankAccount): Int {
        return o1.id.compareTo(o2.id)
    }
}
```



```kotlin
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
```

La clase Main contiene un companion object que se encarga de la inyección de dependencias.
En este caso estamos inyectando el comparador por fecha de creación de BankAccount. De esta forma podemos cambiar el comparador cambiándolo en el companion object del main. Por ejemplo en caso en caso de querer inyectar el comparador por id cambiaríamos la línea de código `val comparator : Comparator<BankAccount> = BankAccountComparatorByCreationDate()` por `val comparator : Comparator<BankAccount> = BankAccountComparatorById()` quedando el código final:

```kotlin
import uy.kohesive.injekt.*
import uy.kohesive.injekt.api.*
import java.time.LocalDate


class Main {
    companion object : InjektMain() {
        @JvmStatic fun main(args: Array<String>) {
            Main().run()
        }

        override fun InjektRegistrar.registerInjectables() {

            val comparator : Comparator<BankAccount> = BankAccountComparatorById()
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
```
