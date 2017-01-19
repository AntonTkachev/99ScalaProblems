package ScalaTasks

import scala.collection.mutable.ListBuffer

object P17 extends App {

  /**
    * P17 (*) Split a list into two parts.
    * The length of the first part is given. Use a Tuple for your result.
    * Example:
    * *
    * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    **/

  def split(num: Int, list: List[Symbol]): (List[Symbol], List[Symbol]) = {
    var firstList = new ListBuffer[Symbol]()
    var secondList = new ListBuffer[Symbol]()
    var length = 1
    list.foreach({ l => l
      if (length <= num) {
        firstList += l
      }
      else {
        secondList += l
      }
      length += 1
    })
    (firstList.toList, secondList.toList)
  }

  val res = split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(res)
}
