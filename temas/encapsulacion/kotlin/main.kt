fun main() {
    println("Creating a rectangle with width 10 and height 20")
    var myRectangle : Rectangle = Rectangle(10,20); // Class Constructor

    println("Rectangle width: ${myRectangle.width}")
    println("Rectangle height: ${myRectangle.height}")
    println("Rectangle area: ${myRectangle.area}")

    printSeparator()
    println("Setting width to -10")
    try {
        myRectangle.width = -10 // myRectangle.width calls the setter
    }
    catch(e: IllegalArgumentException) {
        println(e.message)
    }
    printSeparator()

    println("Setting height to -20");
    try {
        myRectangle.height = -20 // myRectangle.height calls the setter
    }
    catch(e:IllegalArgumentException) {
        println(e.message)
    }
    printSeparator()

    printRectangle(myRectangle)
    printSeparator()

    println("Setting width to 100")
    myRectangle.width = 100
    println("Setting height to 200")
    printSeparator()
    myRectangle.height = 200
    printRectangle(myRectangle)
    printSeparator()
}

fun printRectangle(myRectangle:Rectangle):Unit{
    println("Rectangle width: ${myRectangle.width}") // myRectangle.width calls the width getter
    println("Rectangle height: ${myRectangle.height}") // myRectangle.height calls the getter
    println("Rectangle area: ${myRectangle.area}") // myRectangle.area calls the getter
}

fun printSeparator():Unit{
    println("------------------------")
}