package app.theone.kotlinswingg.ui.model

import java.awt.Color
import java.awt.Graphics2D

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class Box(val position: Position) : Shape {
    val width: Int = 10
    val height: Int = 10
    override fun move(movement: Movement) {
        position.x + movement.dx
        position.y + movement.dy
    }

    override fun draw(graphic: Graphics2D) {
        graphic.color = Color.RED
        graphic.fillRect(position.x, position.y, width, height)
    }
}