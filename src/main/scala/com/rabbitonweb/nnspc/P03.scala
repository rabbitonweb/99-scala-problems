package com.rabbitonweb.nnspc

import scala.annotation.tailrec

class P03[T] {

  final def findNthElement(n: Int, list: List[T])(f: Int => Boolean): Option[T] = {
    @tailrec
    def nth(n: Int, list: List[T]): Option[T] = (n, list) match {
      case (0, head :: tail) => Some(head)
      case (_, Nil) => None
      case (x, _) if(f(x)) => None
      case (x, head :: tail) => nth(x - 1, tail)
    }
    nth(n, ls)
  }

  val ls = 1 :: 2 :: 3 :: 3 :: 8 :: 11 :: 22 :: 25 :: 27 :: Nil

  val nthElem = findNthElement(4, ls)(x => x < 0) // returns Some(8)
}
