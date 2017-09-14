package app.theone.kotlinswingg.ui.model


class Direction {
    companion object {
        val UP = Movement(0, -1)
        val DOWN = Movement(0, 1)
        val LEFT = Movement(-1, 0)
        val RIGHT = Movement(1, 0)
    }

}