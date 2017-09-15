package app.theone.kotlinswingg.ui.model


class TouchArea(val position: Position, val height: Int, val width: Int) {
    fun isTouched(touchArea: TouchArea) : Boolean {
        return Math.abs(position.x - touchArea.position.x) <= height/2 && Math.abs(position.y - touchArea.position.y) <= height/2
    }

}