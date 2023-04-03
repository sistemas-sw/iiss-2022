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