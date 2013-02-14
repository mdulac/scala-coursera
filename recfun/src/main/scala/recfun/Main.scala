package recfun

import common.{ ??? => ??? }

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

    if (c < 0 || r < 0) 0
    else if (c == 0 && r == 0) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def process(chars: List[Char], sum: Int): Boolean = {

      if (sum < 0) false
      else if (chars.isEmpty) (sum == 0)

      else chars.head match {
        case '(' => process(chars.tail, sum + 1)
        case ')' => process(chars.tail, sum - 1)
        case _ => process(chars.tail, sum)
      }
    }

    process(chars, 0);

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    coins.sortWith((e1, e2) => (e1 compareTo e2) > 0)

    def process(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money < 0) 0
      else if (coins.isEmpty && money >= 1) 0

      else
        process(money, coins.tail) + process(money - coins.head, coins)
    }
    
    process(money, coins);
  }
}
