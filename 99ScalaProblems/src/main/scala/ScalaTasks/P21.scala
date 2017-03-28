package ScalaTasks

import scala.collection.mutable.ListBuffer

object P21 extends App {

  def insertAt(newElement: Symbol, position: Int, list: List[Symbol]): List[Symbol] = {
    val (head, tail) = list.splitAt(position)
    List(head, List(newElement), tail).flatten
  }

  println(insertAt('b, 3, List('a, 'c)))

}