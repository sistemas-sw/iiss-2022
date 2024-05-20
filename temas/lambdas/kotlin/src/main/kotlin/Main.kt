fun main() {
    val numeros = listOf(1, 2, 3, 4, 5)

    val resultado = myReduce(numeros, 0){ accumulator, item -> accumulator + item }
    println(resultado)
}

fun <T, R> myReduce(list: List<T>, initialValue: R, operation: (R, T) -> R): R {
    var accumulator = initialValue
    for (item in list) {
        accumulator = operation(accumulator, item)
    }
    return accumulator
}
