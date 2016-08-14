import org.scalatest.{FlatSpec, Matchers}

class PalindromeSpec extends FlatSpec with Matchers {

  it should "" in {
    val pal = Main.isPalindrome("xyx")
    pal shouldEqual true
  }

}
