package app.theone.kotlinswingg.ui.model

import java.awt.Color
import java.awt.Graphics2D
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class Box(private val position: Position) : Shape {

    private val width: Int = 10
    private val height: Int = 10
    override fun move(movement: Movement) {
        position.x += movement.dx
        position.y += movement.dy
    }

    override fun draw(graphic: Graphics2D) {
        graphic.color = Color.RED
        graphic.fillRect(position.x, position.y, width, height)
    }
}