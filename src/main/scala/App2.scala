//classes
class Person(age:Int , name:String) {

  def printAge() = {
    println("age:-> "+age)
  }

}

class Per(var age:Int)

//object Person {
//  def printAge() = {
//
//  }
//}

//case classes
abstract class Expr
case class Number(n:Int) extends Expr
case class Sum(e1:Expr,e2:Expr) extends Expr


//Exceptions
class MainClass {

  def raise(args:Array[String]) = {

    try{
      val elems = args.map(Integer.parseInt)
      println(elems.foldRight(0)(_ + _))
    }catch{
      case e:NumberFormatException => {
        println("exception raised")
       // e.printStackTrace()
      }
    }
  }
}






//Trait - can contain implementations and fields

trait Pet {

  var age:Int  = 0
  def greet():String = {
    "hi"
  }
}

trait Animal {
  var name:String = ???
}

trait Cat extends Animal with Pet

class Dog extends Pet{

  override def greet(): String = {
    "woof"
  }
}

trait ExclamatoryGreeter extends Pet {
  override def greet(): String = {
    super.greet() + "!"

  }
}




object  App2 {

  def main(args:Array[String]) = {


    //import java.util.Currency

    val a = 1
    println(a)


    val p = new Person(24, "Aaron")
    p.printAge()


    println(Sum(Number(1), Number(2)) == Sum(Number(1), Number(2)))


    val b = new MainClass()
    b.raise(Array("v1", "v2"))


    val d = new Dog
    println(d.greet())

    //trait Mixins at instantion time
    val d2 = new Dog with ExclamatoryGreeter
    println(d2.greet())

    //Higher Order Functions

    val lst = List(1, 2, 3)


    def printEle(ele:Int) = {
      println("element:=> "+ele.toString)
    }

    lst.foreach(printEle)

    //Higher Order Functions contd.

    def call (f:Int => Int, b:Int) = f(b)

    def plusOne(a:Int):Int = a+1





    println(call(plusOne, 5))
    println(call(x => x * 2, 6))
    println("\n\n")
    //  call( _ + 1)

    //Scala Collections
    //import scala.collection.mutable._
    var nums = scala.collection.mutable.Set(1, 2, 4)
    nums.foreach(println)
    nums = nums.+(6)
    nums.foreach(println)

    println("\n\n")

    var nums_imm = scala.collection.immutable.Set(1, 2, 5)
    nums_imm.foreach(println)
    nums_imm.+=(8)
    nums_imm.foreach(println)
    println("\n\n")


    //Implicit Conversions

        class RichString (s:String) {
          def isBlank = null == s || "" == s.trim
          def isBlan2 = null == s || "" == s.trim
        }

        implicit def toRichString(s:String) = new RichString(s)

        "".isBlank
        "foo".isBlank

        val foo = {

          println("first foo")
          "init"
        }

        foo
        foo
        foo

        lazy val foo_lazy = {

          println("first lazy foo")
          "init"
        }

        foo_lazy
        foo_lazy

        //Generics

        abstract class Currency[T]{
          def currencyTotal():T
        }

        class Rupees[T](total:T) extends Currency[T] {
          override def currencyTotal() = {
            total
          }
        }

        val inr = new Rupees[Int](100)
        println(inr.currencyTotal())



    //Functional APIS
    //Map, flatmap, filter

    val lst1: Seq[List[Int]] = List(List(1,2), List(3,4))
    val lst2: Seq[Int] = lst1.flatten
    lst2.foreach(print)
  }

}
