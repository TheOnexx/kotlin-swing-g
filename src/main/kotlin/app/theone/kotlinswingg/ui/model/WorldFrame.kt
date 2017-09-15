package app.theone.kotlinswingg.ui.model

import app.theone.kotlinswingg.gameplay.model.Field
import java.awt.Graphics
import java.awt.Graphics2D
import java.util.*
import javax.swing.JPanel

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class WorldFrame : JPanel(true) {
    private val fps: Long = 50


    private lateinit var field: Field
    private lateinit var timer: Timer

    fun run() {
        isFocusable = true
        initField()
        startTimer()
    }

    private fun startTimer() {
        timer = Timer(false)
        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateWorld()
            }
        }, 0, fps)
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
        addKeyListener(field)
        repaint()
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
}