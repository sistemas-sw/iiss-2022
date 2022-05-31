# Anotaciones JVM
Creado por Rub�n P�rez Mercado

## Compilaci�n
```
kotlinc AnotJvm.kt
javac Main.java
```
## Ejecuci�n
```
java Main
```
## Explicaci�n
### Anotaciones creadas por el desarrollador:
En Kotlin, las anotaciones que podemos crear s�lo sirven para adjuntar metadatos al c�digo. En Kotlin, declaramos anotaciones usando la palabra `annotation` delante de una clase.
```
annotation class Anot
```
Las anotaciones pueden tener meta-anotaciones:
```
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Anot

```
No obstante, vamos a jugar con las anotaciones que ya vienen en el lenguaje, con las que podremos hacer m�s cosas.
### Anotaciones de kotlin.jvm

Como ya hemos dicho en otros bloques, Kotlin es un lenguaje 100% interoperable con Java. Eso no quita que existan ciertos aspectos en los que Kotlin y Java difieran, y para los que se necesite indicar al compilador ciertas cosas. Por ello, existen las anotaciones del <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/">paquete kotlin.jvm</a>

### C�digo

En nuestro c�digo, hemos creado un ejemplo sencillo con tres de las anotaciones de este paquete:

- JvmName: Es capaz de modificar el nombre de varios elementos del c�digo. En nuestro caso, lo hemos usado para cambiar el nombre de la clase generada con las declaraciones de propiedades y m�todos que no est�n englobadas en ninguna clase (`funKT`). Por defecto, se crear�a el archivo `.class` con nombre `AnotJvmKt.class` (nombre del archivo seguido de 'Kt'), pero con esta anotaci�n el archivo generado ser� `Funciones.class`. Adem�s, hemos renombrado el propio nombre de la funci�n funKT. Este renombramiento s�lo afectar� a las llamadas que se hagas desde c�digo Java: En Kotlin, se seguir� llamando a la funci�n como `FunKT`, mientras que en Java s�lo funcionar� cuando la llamemos como `miFun`.

- JvmField: En Kotlin, no existen los atributos sueltos. Cuando declaramos una propiedad, por dentro se est� generando el atributo (privado siempre), un getter y un setter. El getter tendr� la visibilidad dada a la propiedad, y el setter s�lo existir� en caso de ser una propiedad declarada con `var`, no con `val`. Esta es la raz�n por la que en el resto de bloques s�lo se declaran las propiedades, y las clases quedan con tan poco c�digo. 
Con esta anotaci�n, podemos hacer que el compilador interprete la propiedad como un atributo igual que en Java. En nuestro ejemplo, hemos creado ese atributo (`prop1`), que ser� p�blico y est�tico (por estar dentro del `companion object`).

- JvmStatic: Gracias a esta anotaci�n, podemos referirnos los m�todos y propiedades declaradas dentro de un `companion object` desde c�digo Java igual que los usar�amos si pertenecieran a una clase de Java y fuesen est�ticos. Si no se usa la anotaci�n, tendr�amos que escribir `Companion` (o el nombre asignado al `companion object`) entre el nombre de la clase y el m�todo o propiedad (por ejemplo, `Ejemplo.Companion.JvmSinStatic()`).


