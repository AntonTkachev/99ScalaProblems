package ScalaTasks

import scala.collection.mutable.ListBuffer

object P22 extends App {

  def range(firstElem: Int, lastElem: Int, numImpl: Int = 1) = {
    numImpl match {
      case 1 => val endList = new ListBuffer[Int]()
        for (i <- firstElem to lastElem) {
          endList += i
        }
        endList.toList
      case 2 => firstElem to lastElem toList
      case 3 => List.tabulate(lastElem - firstElem + 1)(_ + firstElem)
      case _ => List("Number of implementation not found")
    }

  }

  println(range(1, 5))

  println(range(14, 88, 2))
}