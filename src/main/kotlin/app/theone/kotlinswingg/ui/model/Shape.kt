package app.theone.kotlinswingg.ui.model

import java.awt.Graphics2D

/**
 * Created by (TheOne) on 13-Sep-17.
 */
interface Shape {
    fun move()
    fun draw(graphic: Graphics2D)
    fun changeDirection(movement: Movement)
    fun getDirection() : Movement
}