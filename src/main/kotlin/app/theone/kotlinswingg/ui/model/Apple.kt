package app.theone.kotlinswingg.ui.model

import java.awt.Color
import java.awt.Graphics2D


class Apple(private val position: Position) : Shape {


    private val WIDTH = 10
    private val HEIGHT = 10

    private val touchArea = TouchArea(position, HEIGHT, WIDTH)
    override fun move() {
        //don't move
    }

    override fun draw(graphic: Graphics2D) {
        graphic.color = Color.BLUE
        graphic.fillOval(position.x, position.y, WIDTH, HEIGHT)
    }

    override fun changeDirection(movement: Movement) {
        //don't move
    }

    override fun getDirection(): Movement {
        // don't move
        return Movement(0, 0)
    }

    override fun getTouchArea() = touchArea

    override fun getPosition() = position

    override fun getWidth() = WIDTH

    override fun getHeight() = HEIGHT
}