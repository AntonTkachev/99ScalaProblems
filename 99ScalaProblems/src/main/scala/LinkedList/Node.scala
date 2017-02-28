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
}

object Test extends App {
  val linkList = new LinkedList

  val list = linkList.createLinkedList

  linkList.addFront(list, 2)
  linkList.addFront(list, 1)
  linkList.addBack(list, 3)
  println(list)
}