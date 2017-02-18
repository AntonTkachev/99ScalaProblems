import scala.collection.mutable.ListBuffer
import util.control.Breaks._

object StrParse extends App {

  val example =
    """TAG
      |	first
      |	first1
      |	first2
      |
      |TAG1
      |	second
      |	second1
      |
      |	TAG2
      |		third
      |		third1
      |
      |			TAG3
      |				fourth
      |				fourth1
      |				fourth2
      |				fourth3
      |
      |TAG4
      |	fifth
      |	fifth1
      | """.stripMargin

  implicit class StringHelper(msg: String) {

    def \(findTag: String): List[String] = {

      val endList = new ListBuffer[String]()

      def f(message: Array[String]): Unit = {
        if (message.nonEmpty) {
          val headMsg = message.head
          val numTabulation = headMsg.split("|").count(_ == "\t")
          if (headMsg.replaceAll("\\W+", "").equals(findTag) && numTabulation < 2) { // TODO подумать над цифрой 2
            endList += headMsg
            childrenFindTag(message.tail, numTabulation)
          }
          f(message.tail)
        }
      }

      def childrenFindTag(message: Array[String], num: Int): Unit = {
        if (message.nonEmpty) {
          val headMsg = message.head
          val numTabulation = headMsg.split("|").count(_ == "\t")
          if (numTabulation >= num) {
            endList += headMsg
            childrenFindTag(message.tail, num)
          }
          else childrenFindTag(message.tail, num)
        }
      }

      f(msg.split("\n"))
      endList.toList
    }

    def getRoot: String = {
      var rootTag: String = null
      breakable {
        msg.split("\n").foreach({ line =>
          if (line.split("|").head.matches("\\w")) {
            rootTag = line
            break()
          }
        })
      }
      rootTag
    }

  }

  (example \ "TAG2").foreach(println)

  //  print(example.getRoot)
}