package app.theone.kotlinswingg.ui.model

import app.theone.kotlinswingg.gameplay.model.Constants
import app.theone.kotlinswingg.gameplay.model.Field
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.ActionEvent
import javax.swing.*

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class WorldFrame : JPanel(true) {
    private val fps: Int = 50


    private lateinit var field: Field
    private lateinit var timer: Timer

    fun run() {
        isFocusable = true
        initField()
        startTimer()
    }

    private fun startTimer() {
        timer = Timer(fps) {
            updateWorld()
        }
        timer.start()
    }

    private fun updateWorld() {
        if(field.isGameEnd()) {

            error("Game Over")

        }
        field.updateWorld()
        repaint()
    }

    private fun initField() {
        field = Field()
        addKeyEventActions()

        repaint()
    }

    private fun addKeyEventActions() {
        inputMap.put(KeyStroke.getKeyStroke("UP"), Constants.MAP_KEY.UP)
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), Constants.MAP_KEY.DOWN)
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), Constants.MAP_KEY.LEFT)
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), Constants.MAP_KEY.RIGHT)

        actionMap.putLambda(Constants.MAP_KEY.UP) {
            field.routeDirection(Direction.UP)
        }
        actionMap.putLambda(Constants.MAP_KEY.DOWN) {
            field.routeDirection(Direction.DOWN)
        }
        actionMap.putLambda(Constants.MAP_KEY.LEFT) {
            field.routeDirection(Direction.LEFT)
        }
        actionMap.putLambda(Constants.MAP_KEY.RIGHT) {
            field.routeDirection(Direction.RIGHT)
        }
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        if(g != null) {
            g as Graphics2D
            field.getWorldObjects().forEach {
                it.first.draw(g)
                it.second.draw(g)
            }
        }

    }

    private fun ActionMap.putLambda(key: Any, action: () -> Unit) {
        this.put(key, object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                action.invoke()
            }

        }
        )
    }
}