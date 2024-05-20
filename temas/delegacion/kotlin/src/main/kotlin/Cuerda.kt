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