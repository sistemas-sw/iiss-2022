fun main(args: Array<String>) {

    val instrumentos: MutableList<Instrumento> = mutableListOf()
    val orquesta = Orquesta(instrumentos)
    orquesta.addInstrumento(Viento())
    orquesta.addInstrumento(Cuerda())
    for(instrumento in orquesta) {
        orquesta.afinar(instrumento);
    }
    orquesta.tocar()
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}