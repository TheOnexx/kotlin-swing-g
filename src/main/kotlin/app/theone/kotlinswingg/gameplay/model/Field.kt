package app.theone.kotlinswingg.gameplay.model

import app.theone.kotlinswingg.ui.model.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener


class Field : KeyListener {


    private var worldObjects: List<Shape> = listOf(Box(Position(10, 20)))

    fun getWorldObjects() = worldObjects


    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent) {
        when(e.keyCode) {
            KeyEvent.VK_UP -> routeDirection(Direction.UP)
            KeyEvent.VK_RIGHT -> routeDirection(Direction.RIGHT)
            KeyEvent.VK_LEFT -> routeDirection(Direction.LEFT)
            KeyEvent.VK_DOWN -> routeDirection(Direction.DOWN)
        }
    }

    private fun routeDirection(movement: Movement) {
        worldObjects.forEach {
            if(it.getDirection() != movement) {
                it.changeDirection(movement)
            }
        }
    }


    override fun keyReleased(e: KeyEvent?) {

    }

    fun updateWorld() {
        worldObjects.forEach { it.move() }
    }
}