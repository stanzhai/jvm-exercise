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
      if (c == 0 || c == r) {
        1
      } else {
        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      var leftParentheses = 0

      def next(current: List[Char]) {
        if (current.nonEmpty && leftParentheses >= 0) {
          val headChar = current.head
          if (headChar == '(') {
            leftParentheses += 1
          }
          if (headChar == ')') {
            leftParentheses -= 1
          }
          next(current.tail)
        }
      }

      next(chars)

      leftParentheses == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      0
    }
  }
