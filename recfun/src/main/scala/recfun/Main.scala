package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(prevChar: List[Char], chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        true
      }
      else {
        if (chars.head == ')' && prevChar.nonEmpty && prevChar.head == '(') {
          isBalanced(prevChar.tail, chars.tail)
        } else if (chars.head == '(' && (prevChar.isEmpty || prevChar.head == '(')) {
          isBalanced(chars.head :: prevChar, chars.tail)
        } else if (chars.head == ')') {
          false
        } else {
          isBalanced(prevChar, chars.tail)
        }
      }
    }
    isBalanced(List.empty, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty) 0
    else if (money == 0) 1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
