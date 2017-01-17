package ScalaTasks

import scala.collection.mutable.ListBuffer

object P13 extends App {

  /**
    * P13 (**) Run-length encoding of a list (direct solution).
    * Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
    * Example:
    * *
    * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) **/

  def encodeDirect(list: List[Symbol]) = {
    var endList = new ListBuffer[(Int, Symbol)]()
    var num, length = 0
    var letter = list.head
    list.foreach(elOfList => {
      length += 1
      if (elOfList == letter) {
        num += 1
        if (length == list.length) {
          endList += new Tuple2(num, letter)
        }
      }
      else {
        endList += new Tuple2(num, letter)
        letter = elOfList
        num = 1
      }
    })
    println(endList.toList)
  }

  encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
}
