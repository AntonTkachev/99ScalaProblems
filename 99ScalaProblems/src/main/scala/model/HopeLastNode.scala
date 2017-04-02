package model

import scala.collection.mutable.ListBuffer

class ParseNode {
  var rootTag: String = _

  var children: List[String] = _

  var next: ParseNode = _
}

object HopeLastNode extends App with Helper {

  def parser(parseFile: String) = {

    val myStructure = parseFile.split("\n")
    val listChildren = new ListBuffer[String]()
    var rootTag: String = ""
    val parserList = new ParserList()

    val listRootTags = myStructure.flatMap({ elem =>
      if (elem.split("|").head.matches("\\w+")) Some(elem)
      else None
    })

    listRootTags.length match {
      case 1 =>
        val clearArray = myStructure.filter(elem => elem != "\r" && elem != " ")
        f(clearArray)
      case _ => print("Root tag should be one")
    }

    def f(str: Array[String]): Unit = {
      if (str.head.split("|").head.matches("\\w+")) {
        rootTag = str.head
        f(str.tail)
      }
      else if (numOfTab(str.head) == numOfTab(str(1))) {
        listChildren += str.head
        if (str.tail.length != 1) f(str.tail)
        else {
          listChildren += str(1)
          parserList.addNext(rootTag, listChildren.toList)
        }
      }
      else if (numOfTab(str.head) < numOfTab(str(1))) {
        parserList.addNext(rootTag, listChildren.toList)
        rootTag = str.head
        listChildren.clear()
        if (str.tail.length != 1) f(str.tail)
        else {
          parserList.addNext(rootTag = str.head)
          parserList.addNext(rootTag = str(1))
        }
      }
      else str
    }

    parserList
  }

  def numOfTab(strFind: String): Int = {
    strFind.split("|").count(_.equals("\t"))
  }


  parser(exampleWithManyRootTag)

  val result = parser(exampleWithOneRootTag)
  result
}

class ParserList {
  private var head: ParseNode = _
  private var tail: ParseNode = _

  def addNext(rootTag: String, children: List[String] = List.empty) = {
    val tmp = new ParseNode()
    tmp.rootTag = rootTag
    if (children.nonEmpty) tmp.children = children
    if (head == null) {
      head = tmp
      tail = tmp
    }
    else {
      tail.next = tmp
      tail = tmp
    }
  }
}