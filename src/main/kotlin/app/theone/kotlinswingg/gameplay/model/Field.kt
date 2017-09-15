package app.theone.kotlinswingg.gameplay.model

import app.theone.kotlinswingg.ui.model.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.concurrent.ThreadLocalRandom


class Field : KeyListener {


    private var worldObjects: List<Snake> = listOf(Snake(Box(Position(10, 20))))
    private var food: MutableList<Shape> = ArrayList()
    private var tick: Int = 0

    fun getWorldObjects() = worldObjects.zip(food)

    init {
        val randX = ThreadLocalRandom.current().nextInt(Constants.FIELD_WIDTH)
        val randY = ThreadLocalRandom.current().nextInt(Constants.FIELD_HEIGHT)

        food.add(Apple(Position(randX, randY)))
        worldObjects.forEach { it.changeDirection(Direction.RIGHT) }

    }

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
                tick = 1
            }
        }
    }


    override fun keyReleased(e: KeyEvent?) {

    }

    fun updateWorld() {
        var isEaten = false
        worldObjects.forEach { obj ->
            food.forEach {
                if(obj.isTouched(it.getTouchArea())) {
                    obj.addBody()
                    isEaten = true
                }
            }
            if(isEaten) {
                refreshFood()
            }
            if(tick != 0 && tick < obj.getSnakeSize()) {
                obj.changeDirectionTo(tick)
                tick++
            } else {
                tick = 0
            }
            obj.move()
        }
    }

    private fun refreshFood() {
        val randX = ThreadLocalRandom.current().nextInt(Constants.FIELD_WIDTH)
        val randY = ThreadLocalRandom.current().nextInt(Constants.FIELD_HEIGHT)

        food.removeAt(0)
        food.add(Apple(Position(randX, randY)))


    }

    fun isGameEnd(): Boolean {
        return false
    }


}