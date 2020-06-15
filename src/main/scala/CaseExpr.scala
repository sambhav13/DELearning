object CaseExpr extends App{

  val a = 1
  val b = "hello"


  a match {
    case e1:Int => println("int:"+e1)
    case default => println("nothing matched")
  }

  val tup1 = (a,b)

  tup1.productIterator.foreach(p => {
  p match {
    case e1:Int => println("tuple int matched:"+e1)
    case default => println("nothing matched")
  }})

  val s1 = scala.collection.immutable.Set(1,3,4)



}
