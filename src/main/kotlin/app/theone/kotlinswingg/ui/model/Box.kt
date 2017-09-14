package app.theone.kotlinswingg.ui.model

import java.awt.Color
import java.awt.Graphics2D

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class Box(private val position: Position) : Shape {

    private val width: Int = 10
    private val height: Int = 10
    private var direction = Direction.RIGHT
    override fun move() {
        position.x += direction.dx
        position.y += direction.dy
    }

    override fun changeDirection(movement: Movement) {
        direction = movement
    }


    override fun draw(graphic: Graphics2D) {
        graphic.color = Color.RED
        graphic.fillRect(position.x, position.y, width, height)
    }

    override fun getDirection() = direction
}