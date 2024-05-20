# Undefined Kotlin

## Construir el programa

La construcción del programa se hará a través de gradle, ejecutaremos los siguientes comandos desde el directorio base.

```bash
./gradlew build
```

Para ejecutar el comando usaremos el siguiente comando.

```bash
./gradlew run
```

## Ejemplos

`Album.kt`

```kotlin
import java.util.LinkedList

class Album (val name:String, val tracks : List<Track>)
```

`Track.kt`

```kotlin
class Track (val duration : Double)
```

`AlbumService.kt`

```kotlin
class AlbumService {
    private val albumMap = HashMap<String,Album>()
    public fun getDurationOfAlbumWithName(name: String): Double? {
        val album: Album? = getAlbum(name)
        val tracks: List<Track> = getAlbumTracks(album?.name) ?: return null //Elvis Operator.
        var duration : Double = 0.0
        for (track in tracks) {
            duration += track.duration
        }
        return  duration
    }

    private fun getAlbumTracks(name: String?): List<Track>? {
        return albumMap[name]?.tracks
    }

    private fun getAlbum(name: String): Album? {
        return albumMap[name]
    }

    public fun addAlbum(album: Album) {
        albumMap[album.name] = album
    }
}
```

`Main.kt`

```kotlin
import java.util.LinkedList

fun main(){
    val tracks1 = listOf<Track>(Track(3.0), Track(1.0), Track(1.0))
    val tracks2 = listOf<Track>(Track(5.1), Track(1.2), Track(1.4))
    val tracks3 = listOf<Track>(Track(2.1), Track(1.0), Track(1.4))

    val album1 = Album("Album 1", tracks1)
    val album2 = Album("Album 2", tracks2)
    val album3 = Album("Album 3", tracks3)

    var albumService = AlbumService()

    albumService.addAlbum(album1)
    albumService.addAlbum(album2)
    albumService.addAlbum(album3)

    println(albumService.getDurationOfAlbumWithName("Album 1"))
    println(albumService.getDurationOfAlbumWithName("Album 2"))
    println(albumService.getDurationOfAlbumWithName("Album 3"))
    println(albumService.getDurationOfAlbumWithName("Album 4"))
}
```

El mecanismos que usamos en kotlin para controlar los nulos son los `nullables`. Un tipo `nullable` es aquel que puede tomar le valor nulo y se declaran añadiendo una interrogación al final de su declaración, por ejemplo `Album` no puede tomar `null` como valor pero `Album?` sí, esto permite dejar de comprobar si un objeto es nulo porque nunca lo podrá ser a no ser que se declare como `nullable` explicitamente.

Además a la hora de acceder a métodos o propiedades de un tipo nullable podemos controlar el valor nulo usando el operador `?`. Este operador sobre un objeto `nullable` devolverá null en caso de que el objeto sea nulo evitando así las `Null Pointer Exceptions`. Por ejemplo si tenemos un `val album:Album? = Album()` y queremos acceder a la propiedad `name`, lo haremos de la siguiente manera:

```kotlin
val name:String? = album?.name
```

El valor de name será `null` en caso de que album sea nulo y si no tendrá el valor de la propiedad `name`.

```kotlin
public fun getDurationOfAlbumWithName(name: String): Double? {
        val album: Album? = getAlbum(name)
        val tracks: List<Track> = getAlbumTracks(album?.name) ?: return null //Elvis Operator.
        var duration : Double = 0.0
        for (track in tracks) {
            duration += track.duration
        }
        return  duration
    }
    private fun getAlbumTracks(name: String?): List<Track>? {
        return albumMap[name]?.tracks
    }

    private fun getAlbum(name: String): Album? {
        return albumMap[name]
    }
```

Las funciones devolverán nulos en caso de que el tipo lo sea. Además en la línea siguiente:

```kotlin
        val tracks: List<Track> = getAlbumTracks(album?.name) ?: return null 

```

Estamos usando el operador conocido como elvis operator `?:` el cual ejecuta `return null` en caso de que la función getAlbumTracks fuera nulo.
Esto es equivalente a escribir.

```kotlin
    val tracks: List<Track>? = getAlbumTracks(album?.name)

    if(tracks == null)
        return null;
    
    //Resto del código
```

Si estamos seguros que un valor no un objeto no es nulo podemos usar el operador `!!`, el cual es peligroso porque permite que salte la operación de `NullPointerException`

```kotlin
    val tracks: List<Track>? = null

    tracks!!.add(Track()) // NullPointerException
```
