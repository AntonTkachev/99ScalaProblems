package model

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class Parser {

  def parse(str: String) = {

    str.split("\n").foreach({ line =>
      if (line.split("|").head.matches("\\w")) {
        Parser.rootTag += line
      }
    })

    str.split("\n").foreach({ line =>
      val value = if (line.split("=").length > 1) line.split("=")(1) else ""
      Parser.tagValue += (line.split("=").head.replaceAll("\\W+", "") -> value)
    })



  }
}

object Parser {
  var rootTag = new ListBuffer[String]()

//  var tagValue = collection.mutable.Map.empty[String, String]

  var tagValue = new ArrayBuffer[(String,String)]()

  var rootChildren: List[String] = _


  def getRoot = {
    require(rootTag != null)
    this.rootTag
  }

  def getTag(tag: String): Boolean = {
    require(tagValue != null)
    var result = false
    tagValue.foreach({ x =>
      if (x._1 == tag) {
        result = true
      }
    })
    result
  }

  def getValue(tag: String) = {
    require(tagValue != null)
    tagValue.flatMap({ x =>
      if (x._1 == tag && x._2.nonEmpty) {
        Option(x._2)
      }
      else None
    })
  }

  def getChildren = {
    require(rootChildren != null)
    this.rootChildren
  }
}
