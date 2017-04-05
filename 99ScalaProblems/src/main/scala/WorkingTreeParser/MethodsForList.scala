package WorkingTreeParser

import com.typesafe.scalalogging.LazyLogging

import scala.compat.Platform

class MethodsForList extends LazyLogging {

  def listToString(list: ParserList): String = {
    var firstElem = list.head
    val str = new StringBuilder
    while (firstElem != null) {
      str.append(firstElem.rootTag)
      firstElem.children.foreach(str.append)
      str.append(Platform.EOL)
      firstElem = firstElem.next
    }
    str.toString()
  }

  private def printList(list: ParserList): Unit = {
    var firstElem = list.head
    while (firstElem != null) {
      println(firstElem.rootTag)
      firstElem.children.foreach(println)
      print("\n")
      firstElem = firstElem.next
    }
  }

  def returnRootTag(list: ParserList): String = {
    list.head.rootTag
  }

  def getChildren(list: ParserList, rootTag: String = ""): List[String] = {
    var res: List[String] = List.empty[String]
    var firstElem = list.head
    if (rootTag.isEmpty) res = firstElem.children
    else {
      while (firstElem != null) {
        if (firstElem.rootTag.replaceAll("\\W", "") == rootTag) res = firstElem.children
        firstElem = firstElem.next
      }
    }
    if (res.isEmpty) throw new IllegalArgumentException
    else res.map(_.replaceAll("\t", ""))
  }
}
