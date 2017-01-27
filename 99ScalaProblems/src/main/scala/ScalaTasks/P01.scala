package ScalaTasks


object P01 extends App {

  /** P01 (*) Find the last element of a list.
    * Example:
    * *
    * scala> last(List(1, 1, 2, 3, 5, 8))
    * res0: Int = 8
    * */

  def last(list: List[Int]): Int = {
    list.last
  }

  def lastNumOne(list: List[Int]): Int = {
    def f(endList: List[Int]): Int = {
      if (endList.length == 1) {
        return endList.head
      }
      f(endList.tail)
    }
    f(list.tail)
  }

  def lastNumTwo(list: List[Int]) = {
    def f(f: Int, s: Int) = {
      if (list.indexOf(f) > list.indexOf(s)) {
        list(list.indexOf(f))
      }
      else list(list.indexOf(s))
    }
    list.reduceLeft(f)
  }

  def lastNumThree(list: List[Int]): Int = {
    list(list.reduceLeft(list.indexOf(_) max list.indexOf(_)))
  }

  println(last(List(1, 1, 2, 3, 5, 8)))

  println(lastNumOne(List(1, 1, 2, 3, 5, 8)))

  println(lastNumTwo(List(1, 1, 2, 3, 5, 8)))

  println(lastNumThree(List(1, 1, 2, 3, 5, 8)))
}
