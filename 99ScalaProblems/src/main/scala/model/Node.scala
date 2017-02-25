package model

object Node {

  var rootTag: String = _

  var tagValue: Map[String, String] = _

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
