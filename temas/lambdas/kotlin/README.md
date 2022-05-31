# Lambdas
Creado por Rub�n P�rez Mercado

## Compilaci�n
```
kotlinc Main.kt -include-runtime -d Main.jar
```
## Ejecuci�n
```
java -jar Main.jar
```

Si no se dispone del compilador de Kotlin, se puede probar el c�digo en el <a href="https://play.kotlinlang.org/">Playground de Kotlin</a>

## Explicaci�n

En Kotlin, las funciones lambda tienen la siguiente sintaxis:
```
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
```
- La expresi�n lambda estar� delimitada por las llaves.
- Los par�metros de la expresi�n van dentro de ella, y como veremos m�s adelante existen ciertas maneras de escribirlos, aunque la que tenemos en este ejemplo ser�a la forma 'completa'.
- Tenemos el operador `->`, detr�s del cual viene el cuerpo de la funci�n.
- El valor de retorno ser� la �ltima (y a poder ser, �nica) expresi�n dentro del cuerpo de la funci�n.

La funci�n anterior ser�a exactamente igual que la siguiente:
```
val sum = { x: Int, y: Int -> x + y }
```
En este caso, hemos quitado todos los elementos opcionales, y dejamos que el compilador los infiera a partir de los par�metros de la expresi�n y del valor de retorno.

Tambi�n podemos hacer que infiera los par�metros dentro de la funci�n a partir de los tipos a los que se asignan (en este caso, `Int, Int`):
```
val sum: (Int, Int) -> Int = { x, y -> x + y }
```
En cualquier caso, no pueden hacerse las dos omisiones a la vez, pues el compilador no podr� inferir los tipos:
```
val sum:  = { x, y -> x + y } // Compilation Error
```
Si nuestra funci�n lambda consiste en llamar a otra funci�n, podemos optar por hacer lo siguiente: 
```
val upperCase: (String) -> String = String::uppercase
```
Como vemos, aqu� no usamos las llaves.
### Nombre impl�cito del par�metro
En las funciones lambda con un solo par�metro de entrada, podemos su nombre y utilizar la palabra `it`:
```
val upperCase: (String) -> String = { it.uppercase() }
```
Esto es especialmente interesante cuando tenemos una colecci�n cualquiera de elementos, y tenemos que iterar sobre ella:
```
val ints: MutableList<Int> = mutableListOf(1, 2, 3, -1, 0, 4)
val filtrado = ints.filter { it > 0 }
print(filtrado) // Imprime [1, 2, 3, 4]
```
Podemos adem�s hacer cosas como esta:
```
strings.filter { it.length == 5 }.sortedBy { it }.map { it.uppercase() }
```
En las que estar�amos utilizando el par�metro impl�cito en varias ocasiones a la vez.

### Valor de retorno espec�fico
Como hemos dicho antes, en general dejamos que el valor de retorno sea la �ltima expresi�n en el cuerpo de la funci�n. No obstante, podemos indicar qu� queremos devolver exactamente:
```
// Ambos fragmentos son equivalentes
ints.filter {
    val shouldFilter = it > 0
    shouldFilter
}

ints.filter {
    val shouldFilter = it > 0
    return@filter shouldFilter
}
```

### Funciones an�nimas
En Kotlin, las funciones an�nimas ser�an exactamente igual que una funci�n normal, pero sin indicar el nombre de ella:
```
fun(x: Int, y: Int): Int = x + y
// o bien
fun(x: Int, y: Int): Int {
    return x + y
}
```
Donde usemos este tipo de funciones, debemos protegerlas con par�ntesis.
```
ints.filter(fun(item) = item > 0)
```

### Scope Functions

Las scope functions son unos tipos de funci�n que hacen uso de una expresi�n lambda. Existen 5 tipos:
- `with`
- `let`
- `run`
- `apply`
- `also`

Aunque sean bastante parecidas, existen algunas diferencias entre ellas, y cada una se utiliza en un contexto distinto.

### C�digo

En el c�digo, hemos creado un ejemplo para cada uno de los temas anteriormente tratados, en lo que exponemos lo que hemos explicado anteriormente. En el caso de las scope functions, hemos utilizado `with`, que recibe como par�metro el objeto y al que hace referencia usando la palabra `this`, y `let`, que tiene una gran utilidad en caso de disponer de una collecci�n de Nullables, ya que ignorar�a a los elementos de la colecci�n que sean nulos (eso s�, la llamada ser�a `?.let`, ya que si no se pone el interrogante se ejecutar�a sin esa peculiaridad).

