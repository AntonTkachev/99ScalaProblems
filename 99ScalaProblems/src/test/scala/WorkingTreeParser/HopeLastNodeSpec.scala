package WorkingTreeParser

import org.scalatest.{FlatSpec, Matchers}

class HopeLastNodeSpec extends FlatSpec with Matchers {
  val exampleWithManyRootTag =
    """TAG
      |	first =52
      |	first1 =11
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
      |				fourth1 =213
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
      |	first1 =11
      |	first2
      |
      |	TAG2
      |		second =1
      |		second1
      |
      |		TAG4
      |			fourth =11
      |			fourth1 =213
      |			fourth2
      |			fourth3
      |
      | """.stripMargin

  val exampleStartWithNonRootTag =
    """	TAG2
      |		second =1
      |		second1
      |
      |TAG
      |	first =52
      |	first1 =11
      |	first2
      |
      |		TAG4
      |			fourth =11
      |			fourth1 =213
      |			fourth2
      |			fourth3
      | """.stripMargin

  val exampleEndTwoTag = //TODO incorrectly example???
    """TAG
      |	first =52
      |	first1 =11
      |	first2
      |
      |	TAG2
      |		second =1
      |		second1
      |
      |		TAG4
      |			fourth =11
      |			fourth1 =213
      |			fourth2
      |			fourth3
      |
      |		TAG4.1
      |
      |		TAG4.2
      | """.stripMargin

  val exampleLessEnd = //TODO spec with this
    """TAG
      |	first =52
      |	first1 =11
      |	first2
      |
      |	TAG2
      |		second =1
      |		second1
      |
      |		TAG4
      |			fourth =11
      |			fourth1 =213
      |			fourth2
      |			fourth3
      |
      |		TAG4.1
      |			fifth
      |		TAG4.2
      | """.stripMargin

  val newNode = new HopeLastNode()
  val helper = new MethodsForList

  def parser(str: String) = newNode.parser(str)

  it should "return ex" in {
    a[Throwable] shouldBe thrownBy(parser(exampleWithManyRootTag))
  }

  it should "x3" in {
    val result = parser(exampleWithOneRootTag)
    helper.listToString(result).replaceAll("\\s","") shouldEqual exampleWithOneRootTag.replaceAll("\\s","") //TODO dirty hack
  }

  it should "return children of rootTag" in {
    val result = parser(exampleWithOneRootTag)
    helper.getChildren(result).toArray shouldEqual Array("first =52\r", "first1 =11\r", "first2\r")
  }

  it should "return children of tag TAG2" in {
    val result = parser(exampleWithOneRootTag)
    helper.getChildren(result, "TAG2") shouldEqual List("second =1\r", "second1\r")
  }

  it should "return root tag" in {
    val result = parser(exampleWithOneRootTag)
    helper.returnRootTag(result) shouldEqual "TAG\r"
  }

  it should "save structure????" in {
    val result = parser(exampleStartWithNonRootTag)
    result
  }

  it should "return two last root tag without children" in {
    val result = parser(exampleEndTwoTag)
    result
  }
}