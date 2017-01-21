package ScalaTasks

object P04 {

  /** P04 (*) Find the number of elements of a list.
    * Example:
    * *
    * scala> length(List(1, 1, 2, 3, 5, 8))
    * res0: Int = 6
    * */

  private def lengthNumOne(list: List[Int]): Int = {
    list.length
  }

  private def lengthNumTwo(list: List[Int]): Int = {
    var length = 0
    list.foreach({ l => l
      length += 1
    })
    length
  }

  private def lengthNumThree(list: List[Int]): Int = {
    def f(value: Int, lessList: List[Int]): Int = {
      lessList match {
        case Nil => value
        case _ :: tail => f(value + 1, lessList.tail)
      }
    }

    f(0, list)
  }

  private def stupidNumOne(list: List[Int]): Int = {
    list.zipWithIndex.last._2 + 1
  }

  def selectionImplements(numImpl: Int, list: List[Int]) = {
    require(list != null && list.nonEmpty, "List can't be empty or null")
    numImpl match {
      case 1 => lengthNumOne(list)
      case 2 => lengthNumTwo(list)
      case 3 => lengthNumThree(list)
      case 9 => stupidNumOne(list)
      case _ => throw new IllegalArgumentException
    }
  }
}
