package LinkedList

class Node {

  var value: Int = _
  var _next: Node = _
  var _prev: Node = _

}

class DblLinkedList {

  var size = 0
  var head: Node = _
  var tail: Node = _
}

class LinkedList {

  def createLinkedList: DblLinkedList = {
    val tmp = new DblLinkedList

    tmp
  }

  def addFront(list: DblLinkedList, value: Int) = {
    val tmp = new Node

    tmp.value = value
    tmp._prev = null
    tmp._next = list.head
    //TODO думаю неверно
    if (list.head != null) {
      list.head._prev = tmp
    }
    list.head = tmp

    // TODO круговой список?
    if (list.tail == null) {
      list.tail = tmp
    }
    list.size += 1
  }

  def addBack(list: DblLinkedList, value: Int) = {
    val tmp = new Node

    tmp.value = value
    tmp._prev = list.tail
    tmp._next = null

    if (list.tail != null) {
      list.tail._next = tmp
    }
    list.tail = tmp

    if (list.head == null) {
      list.head = tmp
    }
    list.size += 1
  }

  def dellFront(list: DblLinkedList) = {
    if (list.head == list.tail) {
      list.tail = null
    }
    list.head = list.head._next
    list.size -= 1
  }

  def dellBack(list: DblLinkedList) = {
    if (list.head == list.tail) {
      list.tail = null
    }
    list.tail = list.tail._prev
    list.size -= 1
  }

  /*TODO не хочу index передавать, подумать над настройкой _prev _next*/
  def getElem(elem: Node, index: Long): Node = {

    if (elem.value != index) {
      getElem(elem._prev, index)
    }
    else elem
  }

  def dellNum(list: DblLinkedList, index: Long) = {
    require(list.size > index, "Индекс больше колличества членов")
    list.size -= 1
    val requiredElem = getElem(list.tail, index)
    requiredElem._next._prev = requiredElem._prev
    requiredElem._prev._next = requiredElem._next
    requiredElem
  }
}

object Test extends App {
  val linkList = new LinkedList

  val list = linkList.createLinkedList

  linkList.addFront(list, 2)
  linkList.addFront(list, 1)
  linkList.addBack(list, 3)
  linkList.dellNum(list, 2)
  linkList.dellFront(list)
  println(list)
}