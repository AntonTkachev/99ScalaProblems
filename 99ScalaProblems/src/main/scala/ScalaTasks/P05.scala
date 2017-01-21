package ScalaTasks

import scala.collection.mutable.ListBuffer

object P05 extends App {

  /** P05 (*) Reverse a list.
    * Example:
    * *
    * scala> reverse(List(1, 1, 2, 3, 5, 8))
    * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
    * */

  def reverse(list: List[Int]) = {
    list.reverse
  }

  def reverseNumTwo(list: List[Int]): List[Int] = { // TODO очень похоже на велосипед
    var endList = new ListBuffer[Int]()
    def f(newList: List[Int]): List[Int] = {
      newList match {
        case Nil => endList.toList
        case h :: tail => {
          endList += newList.last
          f(newList.take(newList.length - 1))
        }
      }
    }
    f(list)
  }

  def reverseNumThree(list: List[Int]) = {
    var endList = new ListBuffer[Int]()
    def f(num: Int): List[Int] = {
      if (num < list.length - 1) f(num + 1)
      endList += list(num)
      endList.toList
    }
    f(0)
  }

  val res = reverse(List(8, 5, 3, 2, 1, 1))
  println(res)

  val res2 = reverseNumTwo(List(8, 5, 3, 2, 1, 1))
  println(res2)

  val res3 = reverseNumThree(List(8, 5, 3, 2, 1, 1))
  println(res3)
}
