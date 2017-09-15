package app.theone.kotlinswingg.gameplay.model

import app.theone.kotlinswingg.ui.model.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.locks.Lock


class Field  {


    private var worldObjects: List<Snake> = listOf(Snake(Box(Position(10, 20))))
    private var food: MutableList<Shape> = ArrayList()
    private var tick: Int = 0
    private var isGameEnd = false

    fun getWorldObjects() = worldObjects.zip(food)

    init {
        val randX = ThreadLocalRandom.current().nextInt(Constants.FIELD_WIDTH - 10)
        val randY = ThreadLocalRandom.current().nextInt(Constants.FIELD_HEIGHT - 10)

        food.add(Apple(Position(randX, randY)))
        worldObjects.forEach { it.changeDirection(Direction.RIGHT) }

    }


    fun routeDirection(movement: Movement) {
        worldObjects.forEach {
            if(it.getDirection() != movement) {
                it.changeDirection(movement)
                tick = 1
            }
        }
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
            obj.getTail().filterIndexed { index, shape -> index != 0 }.forEach {
                if(obj.isTouchedTail(it)) {
                    isGameEnd = true
                }
            }
            obj.move()
            if(tick != 0 && tick < obj.getSnakeSize()) {
                obj.changeDirectionTo(tick)
                tick++
            } else {
                tick = 0
            }

        }
    }

    private fun refreshFood() {
        val randX = ThreadLocalRandom.current().nextInt(Constants.FIELD_WIDTH - 10)
        val randY = ThreadLocalRandom.current().nextInt(Constants.FIELD_HEIGHT - 10)

        food.removeAt(0)
        food.add(Apple(Position(randX, randY)))


    }

    fun isGameEnd() = isGameEnd


}