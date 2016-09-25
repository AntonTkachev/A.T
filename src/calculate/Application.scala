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
  val button0 = new JButton("0")
  val button1 = new JButton("1")
  val button2 = new JButton("2")
  val button3 = new JButton("3")
  val button4 = new JButton("4")
  val button5 = new JButton("5")
  val button6 = new JButton("6")
  val button7 = new JButton("7")
  val button8 = new JButton("8")
  val button9 = new JButton("9")
  val buttonSum = new JButton("+")
  val buttonBack = new JButton("C")
  val buttonDivide = new JButton("/")
  val buttonSub = new JButton("-")
  val buttonMul = new JButton("*")
  val buttonStart = new JButton("=")

  val valueForButton = List[String]("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "+", "*","/", "-")
  var fullList: util.ArrayList[JButton] = new java.util.ArrayList[JButton]()
  for (i <- valueForButton) {
    fullList.add(new JButton(i))
  }
  var firstValue = 0
  var operation = ""

  for (x <- 0 to 9){
    fullList.get(x).addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        display.setText(display.getText + valueForButton(x))
      }
    })}

  fullList.get(10).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      val temp = display.getText()
      display.setText(temp.substring(0,temp.length()-1))
    }
  })

  fullList.get(11).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      firstValue = Integer.valueOf(display.getText())
      display.setText("")
      operation = "+"
    }
  })

  fullList.get(12).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      firstValue = Integer.valueOf(display.getText())
      display.setText("")
      operation = "*"
    }
  })

  fullList.get(13).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      firstValue = Integer.valueOf(display.getText())
      display.setText("")
      operation = "/"
    }
  })

  fullList.get(14).addActionListener(new ActionListener {
    def actionPerformed(e: ActionEvent): Unit = {
      firstValue = Integer.valueOf(display.getText())
      display.setText("")
      operation = "-"
    }
  })

  buttonStart.addActionListener(new ActionListener() {
    def actionPerformed(e : ActionEvent) {
      val secondValue = Integer.valueOf(display.getText())
      if("+".equals(operation)){
        display.setText((firstValue+secondValue)+"")
      }
      if("-".equals(operation)){
        display.setText((firstValue-secondValue)+"")
      }
      if("*".equals(operation)){
        display.setText((firstValue*secondValue)+"")
      }
      if("/".equals(operation)){
        display.setText((firstValue/secondValue)+"")
      }
      firstValue = 0
      operation = "+"
    }
  })

  setLayout(new BorderLayout())
  add(display, BorderLayout.NORTH)
  add(buttonPanel, BorderLayout.CENTER)
  add(buttonStart,BorderLayout.SOUTH)
  for(i <- valueForButton.indices){
    buttonPanel.add(fullList.get(i))
  }
  setVisible(true)
}

object MyWindowApp {
  def main(args: Array[String]) {
    new Application
  }
}


