package app.theone.kotlinswingg.ui.model

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

/**
 * Created by sech0614 on 9/14/2017.
 */
class Field : KeyListener {


    private var worldObjects: List<Shape> = listOf(Box(Position(10,20)))

    fun getWorldObjects() = worldObjects
    

    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent) {
        when(e.keyCode) {
            KeyEvent.VK_UP -> moveUp()
            KeyEvent.VK_RIGHT -> moveRight()
            KeyEvent.VK_LEFT -> moveLeft()
            KeyEvent.VK_DOWN -> moveDown()
        }
    }

    private fun moveDown() {
        worldObjects.forEach { it.move(Movement(0, 1)) }
    }

    private fun moveLeft() {
        worldObjects.forEach { it.move(Movement(-1, 0)) }
    }

    private fun moveRight() {
        worldObjects.forEach { it.move(Movement(1, 0)) }
    }

    private fun moveUp() {
        worldObjects.forEach { it.move(Movement(0, -1)) }
    }

    override fun keyReleased(e: KeyEvent?) {

    }
}