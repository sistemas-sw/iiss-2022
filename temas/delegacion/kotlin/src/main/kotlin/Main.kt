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