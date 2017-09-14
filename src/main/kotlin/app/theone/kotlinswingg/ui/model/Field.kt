package app.theone.kotlinswingg.ui.model

import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

/**
 * Created by (TheOne) on 13-Sep-17.
 */
class Field : JPanel(true) {
    val fps = 50
    var isRunning = false
    var beginTime: Long = 0
    val fameSkips = 10
    var skipTicks = 1000/fps
    var gameObjects: List<Shape> = listOf(Box(Position(10,20)))

    fun run() {
        beginTime = System.currentTimeMillis()
        isRunning = true
        var nextGameTick = System.currentTimeMillis()
        while(isRunning) {
            var timeDiff = System.currentTimeMillis() - beginTime
            var loopCount = 0
            while (timeDiff > nextGameTick && loopCount < fameSkips) {
                nextGameTick+= skipTicks
                loopCount++
            }
            repaint()
        }
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        if(g != null) {
            g as Graphics2D
            gameObjects.forEach { it.draw(g) }
        }

    }
}