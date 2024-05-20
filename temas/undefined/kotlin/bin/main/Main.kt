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