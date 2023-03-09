# Herencia en Kotlin.

---

## Instalación:

Para la ejecución del siguiente ejemplo es necesario lo siguiente:

- El compilador de CLI de kotlin `kotlinc`
- `openjdk 18.0.0`

## Compilación:

La compilación de los ficheros `.kt` se realizará con el siguiente comando.

```
kotlinc -include-runtime -d Aventura.jar Main.kt Aventura.kt
```

## Ejecución:

La ejecución del fichero `.jar` resultante se realizará con el siguiente comando.

```
java -jar Aventura.jar
```

---

## Mecanismos utilizados:

### Extensión de Clases

Todas las clases de Kotlin heredan de la clase `Any`. Para declara que una clase es subclase de otra se utiliza la sintaxis:

```kotlin
open class Base(x:Int)

class Derivada(x:Int) : Base(x:Int)
```

Por defecto las clases de Kotlin son `final` es decir no pueden ser heredadas. Para hacerlas heredables es necesario usar la keyword `open`. Los métodos también son finales por defecto por lo que habrá que añadirles también la keyword `open`.

Para sobrescribir, las funciones declaradas con `open` se utiliza la palabra `override`.

Las interfaces en Kotlin se declaran con la keyword `interface`, por defecto las interfaces y sus métodos son `open`.

El ejemplo de aventura se implementaría de esta forma.

#### Aventura.java

```java
interface SabeLuchar {
    fun luchar(){println("Luchando sin gracia")}
}

interface SabeNadar {
    fun nadar(){println("Nadando sin gracia")}
}

interface SabeVolar {
    fun volar(){println("Volando sin gracia")}
}

open class PersonajeDeAccion ()
{
    open fun luchar(){println("Luchando como un personaje de acción")}
}

class Heroe : PersonajeDeAccion(), SabeLuchar, SabeNadar, SabeVolar
{
    override fun luchar() {
        println("Luchando como un héroe")
    }


    override fun volar() {
        println("Volando como un héroe")
    }
}

class Aventura
{
    companion object {
        fun t(x: SabeLuchar) {
            x.luchar()
        }
        fun u(x: SabeNadar) {
            x.nadar()
        }
        fun v(x: SabeVolar) {
            x.volar()
        }

        fun w(x: PersonajeDeAccion) {
            x.luchar()
        }
    }
}
```

#### Main.java

```java
fun main()
{
    val miHeroe = Heroe()
    Aventura.t(miHeroe)
    Aventura.u(miHeroe)
    Aventura.v(miHeroe)
    Aventura.w(miHeroe)
}
```
