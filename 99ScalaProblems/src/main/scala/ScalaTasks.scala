import scala.collection.mutable.ListBuffer

object ScalaTasks extends App {

  /**
    * P12 (**) Decode a run-length encoded list.
    * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
    * Example:
    * *
    * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    **/

  def decode(list: List[(Int, Symbol)]) = {
    var endList = new ListBuffer[Symbol]()
    list.foreach(x => {
      val res = List.fill(x._1)(x._2)
      res.foreach(s => endList += s)
    })
    println(endList.toList)
  }

  decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))

  /**
    * P13 (**) Run-length encoding of a list (direct solution).
    * Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
    * Example:
    * *
    * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) **/

  def encodeDirect(list: List[Symbol]) = {
    var endList = new ListBuffer[Any]()
    var num = 0
    var letter: Symbol = list.head
    list.foreach(x => {
      if (x == letter) {
        num += 1
      }
      else {
        endList = endList += (x, letter);
        letter = x
        num = 0
      }
    })
    println(endList.toList)
  }

  encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

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
