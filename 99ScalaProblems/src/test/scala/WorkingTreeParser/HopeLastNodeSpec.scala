package WorkingTreeParser

import org.scalatest.{FlatSpec, Matchers}

class HopeLastNodeSpec extends FlatSpec with Matchers {
  val exampleWithManyRootTag =
    """TAG
      |	first =52
      |	first =11
      |	first2
      |
      |TAG1
      |	second
      |	second1
      |
      |	TAG2
      |		fourth =1
      |		third1
      |
      |			TAG3
      |				fourth =11
      |				fourth =213
      |				fourth2
      |				fourth3
      |
      |TAG4
      |	fifth
      |	fifth1
      | """.stripMargin

  val exampleWithOneRootTag =
    """TAG
      |	first =52
      |	first =11
      |	first2
      |
      |	TAG2
      |		second =1
      |		second1
      |
      |		TAG4
      |			fourth =11
      |			fourth =213
      |			fourth2
      |			fourth3
      | """.stripMargin

  val newNode = new HopeLastNode()
  val helper = new MethodsForList

  def parser(str: String) = newNode.parser(str)

  it should "return ex" in {
    parser(exampleWithManyRootTag) //TODO отловить ошибку?
  }

  it should "x3" in {
    val result = parser(exampleWithOneRootTag)
    helper.printList(result) //TODO как нибудь засунуть в спеку
  }

  it should "return children of rootTag" in {
    val result = parser(exampleWithOneRootTag)
    helper.getChildren(result).toArray shouldEqual Array("first =52\r", "first =11\r", "first2\r")
  }

  it should "return children of tag TAG2" in {
    val result = parser(exampleWithOneRootTag)
    helper.getChildren(result, "TAG2") shouldEqual List("second =1\r", "second1\r")
  }

  it should "return root tag" in {
    val result = parser(exampleWithOneRootTag)
    helper.returnRootTag(result) shouldEqual "TAG\r"
  }
}