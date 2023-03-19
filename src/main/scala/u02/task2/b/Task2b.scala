package u02.task2.b

object Task2b extends App {

  val p1: (Int, Int) => (Int => Boolean) = (y, z) => ({
    case x if ((x <= y) && (y == z)) => true;
    case _ => false
  } )

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x match
    case x if ((x <= y) && (y == z)) => true
    case _ => false

  println("******** Task2b curriedFunType) ********")
  println(p1(5, 5)(2)) //true
  println(p1(10, 2)(8)) //false
  println(p1(5, 5)(20)) //false
  println(p1(6, 6)(1)) //true

  println("******** Task2b NonCurriedFunType) ********")
  println(p2(5, 10, 10)) //true
  println(p2(10, 2, 2)) //false
  println(p2(5, 10, 20)) //false

}
