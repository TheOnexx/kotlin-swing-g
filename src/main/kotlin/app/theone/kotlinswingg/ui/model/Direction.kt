package app.theone.kotlinswingg.ui.model


class Direction {
    companion object {
        val UP = Movement(0, -10)
        val DOWN = Movement(0, 10)
        val LEFT = Movement(-10, 0)
        val RIGHT = Movement(10, 0)
        val NONE = Movement(0, 0)
    }

}