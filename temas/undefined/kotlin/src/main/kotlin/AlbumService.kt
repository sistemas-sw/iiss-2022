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