package OtherThings

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

/**
  * Created by Александр on 05.04.2017.
  */
class ListToMapSpec extends FlatSpec with Matchers {

  /**
    * input List(1,1,1,2,2,1)
    * output Map(1 -> 4,2 -> 2)
    **/
  it should "return list values more count" in {
    val map = mutable.Map[Long, Long]()
    val list: List[Long] = List(1, 1, 1, 2, 2, 1, 3, 3, 3)
    list.foreach({ key =>
      if (map.get(key).isEmpty) map += (key -> 1)
      else {
        val newValue = map(key) + 1
        map.remove(key)
        map += (key -> newValue)
      }
    })
    val count = 3
    val resID = map.flatMap({ x =>
      if (x._2 >= count) Some(x._1)
      else None
    })
    resID
  }
}
