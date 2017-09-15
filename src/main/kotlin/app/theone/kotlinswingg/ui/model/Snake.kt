package app.theone.kotlinswingg.ui.model

import sun.security.provider.SHA
import java.awt.Graphics2D


class Snake(box: Box) : Shape {

    private var body = mutableListOf<Shape>(box)

    override fun move() {
        body.forEach { it.move() }
    }

    override fun draw(graphic: Graphics2D) {
        body.forEach { it.draw(graphic) }
    }

    override fun changeDirection(movement: Movement) {
        body.first().changeDirection(movement)
    }

    override fun getDirection(): Movement {
       return body.first().getDirection()
    }

    override fun getTouchArea(): TouchArea {
        return TouchArea(Position(0,0),0,0)
    }

    fun isTouched(touchArea: TouchArea) : Boolean {
        body.forEach {
            if(it.getTouchArea().isTouched(touchArea)) {
                return true
            }
        }
        return false
    }

    fun addBody() {
        val last = body.last()
        val position = last.getPosition()
        val direction = last.getDirection()
        //val box = Box(position.copy())
        when(direction) {
            Direction.DOWN -> body.add(Box(Position(position.x, position.y - last.getHeight())))
            Direction.UP -> body.add(Box(Position(position.x, position.y + last.getHeight())))
            Direction.LEFT -> body.add(Box(Position(position.x - last.getWidth(), position.y)))
            Direction.RIGHT -> body.add(Box(Position(position.x + last.getWidth(), position.y)))
        }
        //body.last().changeDirection(direction.copy())
     //   body.add(box)

    }

    override fun getPosition() = body.first().getPosition()

    override fun getWidth() = body.first().getWidth()


    override fun getHeight() = body.first().getHeight()

    fun changeDirectionTo(number: Int) {
        body[number].changeDirection(body.first().getDirection())
    }

    fun getSnakeSize() = body.size
}