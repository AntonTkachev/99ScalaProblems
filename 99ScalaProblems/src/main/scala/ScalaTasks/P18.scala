package ScalaTasks

import scala.collection.mutable.ListBuffer


object P18 extends App {

  /**
    * P18 (**) Extract a slice from a list.
    * Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
    * Example:
    * *
    * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    * res0: List[Symbol] = List('d, 'e, 'f, 'g)
    **/

  def slice(firstNum: Int, secondNum: Int, list: List[Symbol]): ListBuffer[Symbol] = {
    var endList = new ListBuffer[Symbol]()
    var length = 1
    list.foreach({ l => l
      if (length > firstNum && length <= secondNum) {
        endList += l
      }
      length += 1
    })
    endList
  }

  val res = slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(res)
}
