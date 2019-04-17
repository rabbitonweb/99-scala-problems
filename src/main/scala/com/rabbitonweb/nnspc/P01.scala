package com.rabbitonweb.nnspc

import scala.annotation.tailrec

class P01[T] {
  def lastElement(list: List[T]): Option[T] = {
    /**
     * @tailrec makes sure that the method will be compiled with tail call optimization
     * that converts the recursive form into a loop
     */
    @tailrec
    def last(list: List[T]): Option[T] = list match {
      case Nil => None
      case head :: Nil => Some(head)
      case head :: tail => last(tail)
    }

    last(list)
  }
}
