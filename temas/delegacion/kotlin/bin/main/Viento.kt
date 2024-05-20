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