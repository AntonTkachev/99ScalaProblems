import scala.collection.mutable.ArrayBuffer

object binarySort extends App {

  def binarySort(ar: ArrayBuffer[Int], value: Int): Unit = {

    def f(firstNum: Int, lastNum: Int): Unit = {
      val mid = (lastNum + firstNum) / 2

      if (ar(mid) == value) {
        println(true)
      }
      else if (lastNum - firstNum == 0) {       //TODO плохо
        if (ar(lastNum - firstNum - 1) == value) println(true)
        else println(false)
      }
      else {
        if (ar(mid) < value) {
          f(mid, lastNum)
        }
        else if (ar(mid) > value) {
          f(0, mid)
        }
      }
    }

    f(0, ar.length - 1)
  }

  binarySort(ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9), 1)
}
