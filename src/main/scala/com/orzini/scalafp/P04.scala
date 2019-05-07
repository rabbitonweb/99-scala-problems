package com.orzini.scalafp

import scala.annotation.tailrec

class P04[T] {

  final def findQty(list: List[T]): Option[Int] = {
    @tailrec
    def numofElems(lt: List[T], xs: List[Int]): List[Int] = lt match {
      case Nil => List()
      case head :: Nil => xs :+ 1
      case head :: tail => numofElems(tail, xs :+ 1)
    }
    Some(numofElems(ls, List()).length)
  }
}
