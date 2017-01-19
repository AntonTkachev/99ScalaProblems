package ScalaTasks

import scala.collection.mutable.ListBuffer

object P20 extends App {

  /** P20 (*) Remove the Kth element from a list.
    * Return the list and the removed element in a Tuple. Elements are numbered from 0.
    * Example:
    * *
    * scala> removeAt(1, List('a, 'b, 'c, 'd))
    * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
    * */

  //TODO сейчас супер тупо сделаю, утром подумать снова
  def removeAt(num: Int, list: List[Symbol]): (List[Symbol], Symbol) = {
    require(num >= 0, "The value should not be less than zero")
    require(num < list.length, "The value should not be more list's length")
    var length = 0
    var endList = new ListBuffer[Symbol]()
    var endElem: Symbol = null
    list.foreach({
      l => l
        if (num != length) endList += l
        else endElem = l
        length += 1
    })
    (endList.toList, endElem)
  }

  val res = removeAt(1, List('a, 'b, 'c, 'd))
  println(res)
}
