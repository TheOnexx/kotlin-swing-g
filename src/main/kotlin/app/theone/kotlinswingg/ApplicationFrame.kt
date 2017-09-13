package app.theone.kotlinswingg

import java.awt.Color
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

/**
 * Created by (TheOne) on 12-Sep-17.
 */
class ApplicationFrame(title: String?) : JFrame(title) {
   // private val SIZE = 30
    private val WIDTH = 1200
    private val HEIGHT = 900

    fun start() {
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE

        val rootPanel = JPanel()
        rootPanel.layout = BoxLayout(rootPanel, BoxLayout.PAGE_AXIS)
        rootPanel.background = Color.WHITE

        preferredSize = Dimension(WIDTH, HEIGHT)



        contentPane = rootPanel
        pack()
        setLocationRelativeTo(null)
        isResizable = false
        isVisible = true
    }
}