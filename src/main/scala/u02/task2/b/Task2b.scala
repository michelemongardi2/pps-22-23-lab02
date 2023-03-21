package u02.task2.b

object Task2b extends App {

  val p1: (Int, Int) => (Int => Boolean) = (y, z) => ({
    case x if ((x <= y) && (y == z)) => true;
    case _ => false
  })

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x match
    case x if ((x <= y) && (y == z)) => true
    case _ => false

  println("******** Task2b CurriedFunType) ********")
  println(p1(5, 5)(2)) //true
  println(p1(10, 2)(8)) //false
  println(p1(5, 5)(20)) //false
  println(p1(6, 6)(1)) //true

  println("******** Task2b NonCurriedFunType) ********")
  println(p2(5, 10, 10)) //true
  println(p2(10, 2, 2)) //false
  println(p2(5, 10, 20)) //false

  def p3(x: Int)(y: Int)(z: Int): Boolean = x match
    case x if ((x <= y) && (y == z)) => true
    case _ => false

  def p4(x: Int, y: Int, z: Int): Boolean = x match
    case x if ((x <= y) && (y == z)) => true
    case _ => false

  println("******** Task2b CurriedMethod) ********")
  println(p3(1)(2)(2)) //true
  println(p3(9)(8)(8)) //false
  println(p3(3)(5)(6)) //false

  println("******** Task2b NonCurriedMethod) ********")
  println(p4(5, 10, 10)) //true
  println(p4(10, 2, 2)) //false
  println(p4(5, 10, 20)) //false

  println("Another way to do the things")

  val differentP1: Int => (Int => (Int => Boolean)) = x => (y => (z => ((x <= y) && (y == z))))
  val differentP2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  def differentP3(x: Int)(y: Int)(z: Int): Boolean = ((x <= y) && (y == z))
  def differentP4(x: Int, y: Int, z: Int): Boolean = ((x <= y) && (y == z))

  println(differentP1(5)(7)(7)) //true
  println(differentP2(1, 2, 2)) //true
  println(differentP3(8)(9)(9)) //true
  println(differentP4(6, 7, 8)) //false

  def compose(f: Int => Int, g: Int => Int): (Int => Int) = x => f(g(x))
  compose(_ - 1, _ * 2)(5) // 9

  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  val addOne: Int => Int = x => x + 1
  val multiplyTwo: Int => Int = x => x * 2

  val composedFunction: Int => Int = genericCompose(addOne, multiplyTwo)
  println(composedFunction(5)) // 11
}