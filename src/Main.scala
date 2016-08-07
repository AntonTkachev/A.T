object Main extends App {


  private def removeSymbols(line: String) = {
    line.replaceAll("[^A-Za-zА-Яа-я0-9]", "").toLowerCase()
  }

  def isPalindrome(str: String) = {
    val myString = removeSymbols(str)
    val lengthMyString = myString.length
    if (lengthMyString % 2 == 0) {
      val halfLen = lengthMyString / 2
      val twoHalves = myString.splitAt(halfLen)

      if (twoHalves._1 equals twoHalves._2.reverse) {
        true
      }
      else {
        false
      }
    }
    else {
      false
    }
  }

  isPalindrome("Sum summus mus")
}
