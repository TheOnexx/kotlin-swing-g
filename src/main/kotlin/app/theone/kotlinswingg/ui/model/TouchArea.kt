package app.theone.kotlinswingg.ui.model


class TouchArea(val position: Position, val height: Int, val width: Int) {
    fun isTouched(touchArea: TouchArea) : Boolean {
      return position.x + width == touchArea.position.x + touchArea.width
              || position.y + height == touchArea.position.y + touchArea.height
    }

}