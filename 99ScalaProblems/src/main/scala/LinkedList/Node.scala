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

  //TODO переписать
  def xx(elem: Node, index: Long): Node = {
    if (elem.value + 1 != index) xx(elem._next, index)
    else elem
  }

  def netNthq(list: DblLinkedList, index: Long) : Node = {
    var tmp = new Node
    var i = 0

    if (index > list.size / 2) {
      i = list.size - 1
      tmp = list.tail
      while (i < index) {
        tmp = tmp._prev
        i -= 1
      }
    }
    else {
      tmp = list.head
      while (i < index) {
        tmp = tmp._next
        i += 1
      }
    }
    tmp
  }

  def dellNum(list: DblLinkedList, index: Long) = {
    require(list.size > index || index < 0, "Неверное значение индекса")

    val requiredElem = netNthq(list, index)
    if (requiredElem._next != null) {
      requiredElem._next._prev = requiredElem._prev
    }
    else {
      requiredElem._next = list.head
    }
    if (requiredElem._prev != null) {
      requiredElem._prev._next = requiredElem._next
    }
    else {
      requiredElem._prev = list.tail
    }

    list.size -= 1
  }

  def inset(list: DblLinkedList, index: Long, value: Int) = {
    if (index < 0 || index > list.size + 1) {
      throw new IllegalArgumentException("Неверное значение индекса")
    }
    val requiredElem = xx(list.head, index)
    val tmp = new Node
    tmp.value = value
    tmp._prev = requiredElem
    tmp._next = requiredElem._next
    requiredElem._next = tmp
    list.size += 1
  }
}

object Test extends App {
  val linkList = new LinkedList

  val list = linkList.createLinkedList

  linkList.addFront(list, 2)
  linkList.addFront(list, 1)
  linkList.addFront(list, 0)
  linkList.addBack(list, 3)
  linkList.addBack(list, 4)
  linkList.inset(list, index = 4, value = 5)
  linkList.netNthq(list, 5)
  linkList.dellNum(list, 5)
  linkList.dellFront(list)
  println(list)
}