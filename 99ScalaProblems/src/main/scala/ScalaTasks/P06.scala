package ScalaTasks

object P06 extends App {

  /** P06 (*) Find out whether a list is a palindrome.
    * Example:
    * *
    * scala> isPalindrome(List(1, 2, 3, 2, 1))
    * res0: Boolean = true
    * */

  def isPalindrome(list: List[Int]): Boolean = {
    var res: Boolean = false
    for (num <- 0 to list.length / 2) {
      if (list(num) == list(list.length - 1 - num)) {
        res = true
      }
      else return false
    }
    res
  }

  println(isPalindrome(List(1, 2, 3, 2, 1)))
}
