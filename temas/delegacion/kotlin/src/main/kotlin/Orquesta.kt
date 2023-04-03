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