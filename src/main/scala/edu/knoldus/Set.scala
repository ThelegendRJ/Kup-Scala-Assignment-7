package edu.knoldus

trait Set[A <: Ordered[A]] {
  def incl(num: A): Set[A]
  def contains(elem: A): Boolean
}

class EmptySet[A<:Ordered[A]] extends Set[A]{
  def incl(num: A): Set[A] =new NonEmptySet(num, new EmptySet[A], new EmptySet[A])
  def contains(elem: A): Boolean =false
}

class NonEmptySet[A<:Ordered[A]](num:A, left:Set[A], right:Set[A])extends Set[A] {
  def incl(num: A): Set[A] = {
    if (num < num) new NonEmptySet(num, left incl (num), right)
    else if (num > num) new NonEmptySet(num, left, right incl (num))
    else this
  }

  def contains(elem: A): Boolean = if (elem < num) left contains (elem)
  else if (elem > num) right contains (elem)
  else (elem == num)
  true
}

case class element(num:Int) extends Ordered[element]{
  def compare(that: element): Int =
    if (this.num < that.num) -1
    else if (this.num > that.num) 1
    else 0
}
