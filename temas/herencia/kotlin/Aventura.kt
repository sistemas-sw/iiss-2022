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