class Rectangle(width:Int,height:Int) {
    var width: Int = width
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Width must be non-negative."
                )
            }
            field = value
        }
    var height: Int = height
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException(
                    "Height must be non-negative."
                )
            }
            field = value
        }
    
    val area: Int
        get() = this.width * this.height
}

