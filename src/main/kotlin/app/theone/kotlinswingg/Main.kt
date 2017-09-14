package app.theone.kotlinswingg

import java.awt.EventQueue

/**
 * Created by (TheOne) on 12-Sep-17.
 */
class Main {

    companion object {
        @JvmStatic
        fun main(arg: Array<String>) {
            println("hello")
            EventQueue.invokeLater {
                ApplicationFrame("Game").start()
            }
        }
    }
}