package week4

import java.util.NoSuchElementException

trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

object List {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil));
  def apply[T]() = new Nil
}


abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero = true
  def predecessor = throw new Error("0.predecessor")
  def +(that: Nat) = that
  def -(that: Nat) = if (that.isZero) this else throw new Error("negative number")
}

class Succ(n: Nat) extends Nat {
  def isZero = false
  def predecessor = n
  def +(that: Nat) = new Succ(n + that)
  def -(that: Nat) = if (that.isZero) this else n - that.predecessor
}

object Main extends App {
  
}