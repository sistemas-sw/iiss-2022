# Funciones Lambda en Kotlin

## Ejecutar el programa

Para ejecutar el el programa hay que ejecutar el siguiente comanod en la terminal dentro del directorio de Kotlin

```bash
./gradlew run
```

## Ejemplo

Para este ejempo vamos a utilizar una implemetación propia de la función `Reduce` para una lista de elementos. Dicha función recibirá una lista de elementos y una función lambda que indicará que operador realizar sobre los elementos.

`Main.kt`

```kotlin

fun main() {
    val numeros = listOf(1, 2, 3, 4, 5)

    val resultado = myReduce(numeros){ accumulator, item -> accumulator + item }

    println(resultado)
}

fun <T, R> myReduce(list: List<T>, initialValue: R, operation: (R, T) -> R): R {
    var accumulator = initialValue
    for (item in list) {
        accumulator = operation(accumulator, item)
    }
    return accumulator
}

```

La función myReduce es una función de orden superior, estas funciones puede recibir funciones como parámetro. También la hemos implementado como una función genérica donde T es el tipo de la lista y R el tipo de dato que devuelve la función lambda.

Para crear una función de orden superior en Kotlin se usa la siguiente sintaxis,

```kotlin
fun foo (x:Int, y:Int, operation: (Int,Int) -> Int):String{
    return operation(x,y).ToString()
}
```

En este caso la operación `foo` recibe como argumento una función de primer orden a la que se le pasan dos enteros y devuelve un string.
A la función foo se la invocaría de la siguiente manera.

```kotlin
foo(3,2){x,y -> x-y}
```

La ultima expresión de una función lambda será lo que retorne la función. Como podemos ver a la hora de crear una función lambda esa función no se envía dentro de los paréntesis en kotlin si no que sigue la siguiente estructura al cerrar el paréntesis de invocacíon.

```kotlin
{ arg1,arg2... -> 
    expresión1
    expresión2
    ...
    expresión de retorno
}
```

Todo lo que se encuentre dentro de los corchetes es la expresión lambda. Aquello que esté antes de `->`
son los parámetros de la función y lo que esté despues las expresiones que se ejecutan.
