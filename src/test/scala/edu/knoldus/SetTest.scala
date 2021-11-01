package edu.knoldus
import org.scalatest.flatspec.AnyFlatSpec

class SetTest extends AnyFlatSpec{
  var obj=new EmptySet[element]
  var obj1=new NonEmptySet[element](element(7),obj.incl(element(6)),obj.incl(element(1)))

  "Condition" should "include element in EmptySet using incl method" in {
    val st1= obj.incl(element(7))
    assert(st1.contains(element(7)))
  }

  "Condition" should "An EmptySet should return false" in {
    assert(! obj.contains(element(7)))
  }

  "condition" should "check weather the element is present in the set tree or not " in {
    val st2 = obj.incl(element(3)).incl(element(6)).incl(element(7)).incl(element(9))
    assert(st2.contains(element(3)))
    assert(!st2.contains(element(11)))
  }

  "condition" should "check weather non empty set has value 7 "in{
    assert(obj1.contains(element(7)))
  }

}
