#Encapsulación Kotlin
----
## Instalación:

Para la ejecución del siguiente ejemplo es necesario lo siguiente:
- El compilador de CLI de kotlin `kotlinc`
- `openjdk 18.0.0`

## Compilación:
La compilación de los ficheros `.kt` se realizará con el siguiente comando.
```
kotlinc -include-runtime  -d BankAccount.jar main.kt BankAccount.kt
```

## Ejecución:
La ejecución del fichero `.jar` resultante se realizará con el siguiente comando.
```
java -jar BankAccount.jar   
```
---
## Mecanismos de ocultación utilizados.
### Getters y Setters:
El acceso a los atributos de un objeto se realiza a través del método `get()` definido debajo del atributo de la clase.
La modificación del atributo del objeto se hace a través del método `set()` definido debajo del atributo.

```kotlin
class Rectangle(width:Int,height:Int) {
    var width: Int = width
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Width must be non-negative."
                )
            }
            field = value
        }

    var height: Int = height
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Height must be non-negative."
                )
            }
            field = value
        }
    
    val area: Int
        get() = this.width * this.height
}
```

Los atributos `width` y `height` tienen un getter predeterminado al no declararlo.

El atributo `area` es un atributo inmutable y cada vez que intentemos leer del mismo llamará a su método `get`.

Los atributos `width` y `height` redefinen su método set y ejecutará el set correspondiente al intentar escribir en el mismo.

El atributo `area` no implementa método `set` al ser inmutable, esto se indica con la *keyword* `val`.

Cabe destacar que los métodos `get` y `set` hacen referencia al propio atributo sobre el que actúan con la keyword `field`, esto es debido a que en caso de de acceder con el nombre del atributo se llamarían a los métodos `get` y `set` del mismo provocando una sucesión infinita de llamadas recursivas

Se puede indicar que un atributo tenga un getter publico y un setter privado de la siguiente forma:

```kotlin
class Rectangle(width:Int,height:Int) {
    var width: Int = width
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Width must be non-negative."
                )
            }
            field = value
            area = field * height
        }

    var height: Int = height
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Height must be non-negative."
                )
            }
            field = value
            area = field * width
        }
    
    var area: Int = width * height
        private set;

}
```

De esta forma el método `set` del atributo área solo podrá ser ejecutado por métodos de la clase, mientras que el método `get` será el por defecto.

### Función Main:
La función main ejecuta las siguientes intrucciones para ejemplificar el uso de los getters y setters.
```kotlin
fun main() {
    println("Creating a rectangle with width 10 and height 20")
    var myRectangle : Rectangle = Rectangle(10,20); // Class Constructor

    println("Rectangle width: ${myRectangle.width}")
    println("Rectangle height: ${myRectangle.height}")
    println("Rectangle area: ${myRectangle.area}")

    printSeparator()
    println("Setting width to -10")
    try {
        myRectangle.width = -10 // myRectangle.width calls the setter
    }
    catch(e: IllegalArgumentException) {
        println(e.message)
    }
    printSeparator()

    println("Setting height to -20");
    try {
        myRectangle.height = -20 // myRectangle.height calls the setter
    }
    catch(e:IllegalArgumentException) {
        println(e.message)
    }
    printSeparator()

    printRectangle(myRectangle)
    printSeparator()

    println("Setting width to 100")
    myRectangle.width = 100
    println("Setting height to 200")
    printSeparator()
    myRectangle.height = 200
    printRectangle(myRectangle)
    printSeparator()
}

fun printRectangle(myRectangle:Rectangle):Unit{
    println("Rectangle width: ${myRectangle.width}") // myRectangle.width calls the width getter
    println("Rectangle height: ${myRectangle.height}") // myRectangle.height calls the getter
    println("Rectangle area: ${myRectangle.area}") // myRectangle.area calls the getter
}

fun printSeparator():Unit{
    println("------------------------")
}
```