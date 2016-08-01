object Main extends App{

  def isPalindrome(str: String) = {
    val s = str.replaceAll(" ", "").toLowerCase
    val len = s.length
    if (len % 2 == 0) {
      val halhLen = len / 2
      val twoHalves = s.splitAt(halhLen)

      if (twoHalves._1 equals twoHalves._2.reverse) {
        println("Это полиндров")
      }
      else {
        println("ХЗ че эт")
      }
    }
    else {
      println("Нечетное")
    }
  }

  isPalindrome("Sum summus mus")
}
