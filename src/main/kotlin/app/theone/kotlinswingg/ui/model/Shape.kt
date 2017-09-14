package app.theone.kotlinswingg.ui.model

import java.awt.Graphics2D

/**
 * Created by (TheOne) on 13-Sep-17.
 */
interface Shape {
    fun move(movement: Movement)
    fun draw(graphic: Graphics2D)
}