package com.orzini.scalafp

class P05[T] {
  def reverseList(list: List[T]): List[T] = {

    @tailrec
    def reverse(list: List[T], acc: List[T]): List[T] = list match {
      case Nil => acc
      case head :: tail => reverse(tail, List(head) ::: acc) // ::: adds the elements in the front of the list
    }
    reverse(list, List())
  }
}
