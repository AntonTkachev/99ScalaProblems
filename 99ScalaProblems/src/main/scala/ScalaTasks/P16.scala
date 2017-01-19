package ScalaTasks

import scala.collection.mutable.ListBuffer

object P16 extends App {

  /**
    * P16 (**) Drop every Nth element from a list.
    * Example:
    * *
    * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    **/

  def drop(num: Int, list: List[Symbol]): List[Symbol] = {
    var endList = new ListBuffer[Symbol]()
    var length = 1
    list.foreach({ l => l
      if (length % num != 0) {
        endList += l
      }
      length += 1
    })
    endList.toList
  }

  val res = drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(res)
}
