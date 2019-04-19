package com.orzini.scalafp

import scala.annotation.tailrec

class P03[T] {

  // currying and higher-order function that returns Boolean
  def findNthElement(list: List[T], n: Int)(f: (T, T) => Boolean): Option[T] = {
    @tailrec
    def nth(list: List[T], acc: (T, T)): Option[T] = list match {
      case Nil => None
      case head :: tail => {
        if(f(acc._1, acc._2))
          Some(head)
        else
          nth(tail, (acc._1 + 1, acc._2))
      }
    }
    nth(list, (0, n))
  }

  val ls = 1 :: 2 :: 3 :: 5 :: 8 :: 11 :: 22 :: 25 :: 27 :: Nil

  val nthElem = findNthElement(ls, 4)((x,y) => x == y)
}
