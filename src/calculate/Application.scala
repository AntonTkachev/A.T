package calculate

import java.awt.event.{ActionEvent, ActionListener}
import java.awt._
import java.util
import javax.swing.{JButton, _}

import scala.List
import scala.collection.mutable.ArrayBuffer

/**
  * Created by Александр on 24.09.2016.
  */
class Application extends JFrame("My First Window") {

  setBounds(300, 300, 300, 300)
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

  val display = new JTextArea()
  val buttonPanel = new JPanel(new GridLayout(3, 5))
  val buttonStart = new JButton("=")

  val valueForButton = List[String]("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "+", "*", "/", "-")
  var fullList: util.ArrayList[JButton] = new java.util.ArrayList[JButton]()
  for (i <- valueForButton) {
    fullList.add(new JButton(i))
  }
  var firstValue = 0
  var operation = ""

  for (x <- 0 to 9) {
    fullList.get(x).addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        display.setText(display.getText + valueForButton(x))
      }
    })
  }

  fullList.get(10).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      val temp = display.getText()
      if (temp.nonEmpty) {
        display.setText(temp.dropRight(1))
      }
    }
  })

  for (z <- 11 to 14) {
    fullList.get(z).addActionListener(new ActionListener {
      def actionPerformed(e: ActionEvent): Unit = {
        firstValue = Integer.valueOf(display.getText())
        if (firstValue.toString.nonEmpty) {
          display.setText("")
          operation = valueForButton(z)
        }
      }
    })
  }

  buttonStart.addActionListener(new ActionListener() {
    def actionPerformed(e: ActionEvent) {
      val secondValue = Integer.valueOf(display.getText())
      if ("+".equals(operation)) {
        display.setText((firstValue + secondValue) + "")
      }
      if ("-".equals(operation)) {
        display.setText((firstValue - secondValue) + "")
      }
      if ("*".equals(operation)) {
        display.setText((firstValue * secondValue) + "")
      }
      if ("/".equals(operation)) {
        display.setText((firstValue / secondValue) + "")
      }
      firstValue = 0
      operation = "+"
    }
  })

  setLayout(new BorderLayout())
  add(display, BorderLayout.NORTH)
  add(buttonPanel, BorderLayout.CENTER)
  add(buttonStart, BorderLayout.SOUTH)
  for (i <- valueForButton.indices) {
    buttonPanel.add(fullList.get(i))
  }
  setVisible(true)
}

object MyWindowApp {
  def main(args: Array[String]) {
    new Application
  }
}


