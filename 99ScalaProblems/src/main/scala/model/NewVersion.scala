package model

import scala.collection.mutable.ArrayBuffer

object NewVersion extends App {

  val DOM = ArrayBuffer(
    List("TAG", "first =52", "first =11", "first2"),
    List("TAG1", " second", " second1",
      List("TAG2", "third", "third1",
        List("TAG3", "fourth", "fourth1", "fourth2", "fourth3")
      )
    ),
    List("TAG4", "fifth", "fifth1")
  )

  //TODO переписать
  def getChildren(child: String): Unit = {
    DOM.foreach({ x =>

      f(x)

      def f(list: List[Any]) {
        if (list.head == child) {

          matching(list)

          def matching(l: List[Any]): Unit = {
            l.last match {
              case lastList: List[String] =>
                for (num <- 0 to l.length - 2) {
                  println(l(num))
                }
                matching(lastList)
              case lastString: String => l.foreach(println)
            }
          }

        }
        else {
          list.last match {
            case lastList: List[String] => f(list)
            case _ =>
          }
        }
      }
    })

  }

  getChildren("TAG1")
}
