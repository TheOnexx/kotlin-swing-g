package app.theone.kotlinswingg.ui.model

import java.awt.Graphics2D


class Snake(box: Box) : Shape {

    private var tail = mutableListOf<Shape>(box)

    override fun move() {
        tail.forEach { it.move() }
    }

    override fun draw(graphic: Graphics2D) {
        tail.forEach { it.draw(graphic) }
    }

    override fun changeDirection(movement: Movement) {
        tail.first().changeDirection(movement)
    }

    override fun getDirection(): Movement {
       return tail.first().getDirection()
    }

    override fun getTouchArea(): TouchArea {
        return TouchArea(Position(0,0),0,0)
    }

    fun isTouched(touchArea: TouchArea) : Boolean {
        tail.forEach {
            if(it.getTouchArea().isTouched(touchArea)) {
                return true
            }
        }
        return false
    }

    fun addBody() {
        val last = tail.last()
        val position = last.getPosition()
        val direction = last.getDirection()
        when(direction) {
            Direction.DOWN -> tail.add(Box(Position(position.x, position.y - last.getHeight())))
            Direction.UP -> tail.add(Box(Position(position.x, position.y + last.getHeight())))
            Direction.LEFT -> tail.add(Box(Position(position.x + last.getWidth(), position.y)))
            Direction.RIGHT -> tail.add(Box(Position(position.x - last.getWidth(), position.y)))
        }
        tail.last().changeDirection(direction.copy())

    }

    override fun getPosition() = tail.first().getPosition()

    override fun getWidth() = tail.first().getWidth()


    override fun getHeight() = tail.first().getHeight()

    fun changeDirectionTo(number: Int) {
        tail[number].changeDirection(tail[number - 1].getDirection().copy())
    }

    fun getSnakeSize() = tail.size

    fun getTail() = tail
    fun isTouchedTail(box: Shape): Boolean {
        return tail.first().getTouchArea().isTouched(box.getTouchArea())
    }
}