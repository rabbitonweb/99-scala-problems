package com.orzini.scalafp

import java.util.NoSuchElementException
import scala.annotation.tailrec

class P02[T] {

  // Scala library methods
  def penultimateFromLib1(ls: List[T]): Option[T] = {
    if(ls.isEmpty) throw new NoSuchElementException
    else Some(ls.init.last) // 'init' method selects all elements except the last
  }

  def penultimateFromLib2(ls: List[T]): Option[T] = {
    if(ls.isEmpty) throw new NoSuchElementException
    else Some(ls.reverse.drop(1).head)
  }

  def penultimate(ls: List[T]): Option[T] = {
    @tailrec
    def preLastElement(ls: List[T]): Option[T] = ls match {
      case head :: mid :: Nil => Some(head)
      case head :: tail => preLastElement(tail)
      case _ => throw new NoSuchElementException
    }
    preLastElement(ls)
  }
}
