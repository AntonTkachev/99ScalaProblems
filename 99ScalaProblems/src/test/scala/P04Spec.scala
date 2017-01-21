import ScalaTasks.P04
import org.scalatest._

class P04Spec extends FlatSpec with Matchers {

  "Method selectionImplements" should "return IllegalArgumentException if list equals null" in {
    a[IllegalArgumentException] should be thrownBy P04.selectionImplements(1, null)
  }

  it should "return IllegalArgumentException if list is empty" in {
    a[IllegalArgumentException] should be thrownBy P04.selectionImplements(1, List())
  }

  it should "return IllegalArgumentException if numImpl" in {
    a[IllegalArgumentException] should be thrownBy P04.selectionImplements(11, List(1, 1, 2, 3, 5, 8))
  }

  it should "return all implements" in {
    val optionsImpl = List(1, 2, 3, 9)
    val inputList = List(1, 1, 2, 3, 5, 8)
    optionsImpl.map({ num =>
      lazy val res = P04.selectionImplements(num, inputList)
      res shouldEqual inputList.length
    })
  }
}
