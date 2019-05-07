package com.orzini.scalafp

import java.util.NoSuchElementException
import scala.annotation.tailrec

class P01[T] {

  // Scala library method
  def lastFromLib(ls: List[T]): Int = ls.last

  def lastElement(list: List[T]): Option[T] = {
    /**
     * @tailrec makes sure that the method will be compiled with tail call optimization
     * that converts the recursive form into a loop
     */
    @tailrec
    def last(list: List[T]): Option[T] = list match {
      case head :: Nil => Some(head)
      case head :: tail => last(tail)
      case _ => throw new NoSuchElementException
    }

    last(list)
  }
}
