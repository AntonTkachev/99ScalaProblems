package ScalaTasks

object P19 extends App {

  /** P19 (**) Rotate a list N places to the left.
    * Examples:
    * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    * *
    * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    * */

  def rotate(num: Int, list: List[Symbol]) = {
    num match {
      case 0 => list
      case more if more > 0 =>
        list.splitAt(num)._2 ++ list.splitAt(num)._1
      case less if less < 0 =>
        val numToSplit = list.length + less
        list.splitAt(numToSplit)._2 ++ list.splitAt(numToSplit)._1
    }
  }

  val numMoreZero = rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(numMoreZero)

  val numLessZero = rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(numLessZero)

  val numEqualsZero = rotate(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  println(numEqualsZero)
}
