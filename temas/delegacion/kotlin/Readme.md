# Delegación en Kotlin

## Ejemplo

Para el ejemplo de delegación adaparemos el ejemplo de Orquesta en Kotlin utilizando un mecanismo propio del lenguaje, llamado `Delegation`.

El mecanismo consiste en los siguiente según el manual de Kotlin: 

Una clase `Derivada` puede implementar una interfaz `Base` delegando todos sus miembros públicos a un objeto especificado de la siguiente manera.

```kotlin
interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
}
```

El objeto en cuestión ha de implementar la interfaz base. Siguientdo esta línea propongo el siguiente ejemplo:

Cuerda.kt

```kotlin
class Cuerda : Instrumento() {
    override fun afinar() {
        println("Afinar rasgado")
    }

    override fun tocar() {
        rasgar()
    }

    private fun rasgar(){
        println("Rasgando...")
    }
}
```

Viento.kt

```kotlin
class Viento : Instrumento(){
    override fun tocar() {
        soplar()
    }

    override fun afinar(){
        println("Afinar soplido")
    }

    private fun soplar(){
        println("Soplando...")
    }
}
```

Instrumento.kt

```kotlin
abstract class Instrumento {
    abstract fun tocar();
    companion object{
        fun afinarInstrument(i: Instrumento){
            i.afinar();
            i.tocar();
        }
    }
    abstract fun afinar();
}
```

Orquesta.kt

```kotlin
class Orquesta (private val instrumentos : MutableList<Instrumento>) : Iterable<Instrumento> by instrumentos{
    fun addInstrumento(instrumento: Instrumento): Boolean{
        return instrumentos.add(instrumento)
    }

    fun removeInstrumento(instrumento : Instrumento) : Boolean{
        return instrumentos.remove(instrumento)
    }

    fun tocar(){
        for(instrumento in this)
            instrumento.tocar()
    }

    fun afinar(instrumento: Instrumento){
        instrumento.afinar()
        instrumento.tocar()
    }
}
```

Main.kt

```kotlin
fun main(args: Array<String>) {

    val instrumentos: MutableList<Instrumento> = mutableListOf()
    val orquesta = Orquesta(instrumentos)
    orquesta.addInstrumento(Viento())
    orquesta.addInstrumento(Cuerda())
    for(instrumento in orquesta) {
        orquesta.afinar(instrumento)
    }
    orquesta.tocar()
}
```

Como podemos ver en este caso el iterador queda automáticamente delegado al de la clase Lista que implementa la interfaz. Sería posible hacerlo también para los métodos addInstrumento haciendo que sean implementados los métodos add de la lista pero en este caso he querido mantener la firma del método.

## Construcción

Para construir la app usaemos gradle y usaremos el siguiente comando.

`./gradlew run`