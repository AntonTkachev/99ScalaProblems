package ScalaTasks

import scala.collection.mutable.ListBuffer

object P14and15 extends App {

  /**
    * P14 (*) Duplicate the elements of a list.
    * Example:
    * *
    * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
    * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    **/

  def duplicate(list: List[Symbol], numOfIter: Int = 2) = {
    var endList = new ListBuffer[Symbol]()
    list.foreach(x => {
      for (i <- 1 to numOfIter) {
        endList += x
      }
    })
    println(endList)
  }

  duplicate(List('a, 'b, 'c, 'c, 'd))

  /**
    * P15 (**) Duplicate the elements of a list a given number of times.
    * Example:
    * *
    * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
    * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    **/

  duplicate(List('a, 'b, 'c, 'c, 'd), 3)
}
