package ScalaTasks

import java.util.Random

import scala.collection.mutable.ListBuffer

object P23 extends App {

  def randomSelect(numOfELem: Int, list: List[Int]): List[Int] = {
    val endList = new ListBuffer[Int]()
    for (i <- 0 until numOfELem) {
      val random = new Random
      val num = random.nextInt(list.length)
      endList += list(num)
    }
    endList.toList
  }

  println(randomSelect(3, List(0, 1, 2, 3, 4, 5, 6, 7)))
}