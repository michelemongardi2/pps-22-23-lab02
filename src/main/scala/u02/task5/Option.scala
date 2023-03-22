package u02.task5

object Option extends App {

  import u02.Optionals._
  import u02.Optionals.Option._

  println("****** More Functional Combinators ******")

  def filter[A](opt: Option[A])(predicate: A => Boolean): Option[A] = opt match
    case None() => None()
    case Some(a) if (predicate(a)) => Some(a)
    case _ => None()

  println("****** Test Filter ******")
  println(filter(Some(5))(_ > 2)) //Some(5)
  println(filter(Some(5))(_ > 8)) // None
  println(filter(None[Int]())(_ > 2)) // None

  def map[A, B](opt: Option[A])(predicate: A => B): Option[B] = opt match
    case None() => None()
    case Some(a) => Some(predicate(a))

  println("****** Test Map ******")
  println(map(Some(5))(_ > 2)) // Some(true)
  println(map(Some(5))(_ > 8)) // Some(false)
  println(map(None[Int]())(_ > 2)) // None

  def fold[A](opt: Option[A])(default: A)(predicate: A => A): A = opt match
    case None() => default
    case Some(a) => predicate(a)

  println("****** Test Fold ******")
  println(fold(Some(5))(1)(_ + 1)) // 6
  println(fold(None[Int]())(1)(_ + 1)) // 1

  println("****** A Challeng - Slide 48 02fp ******")

  /**
   * Implement a method that takes an Optional[Int] and doubles its
   * content (if not empty)
   */

  def doubleOpt(opt: Option[Int]): Option[Int] = opt match
    case None() => None()
    case Some(a) => Some(a*2)

  println("****** Double Opt ******")
  println(doubleOpt(Some(10))) //20
  println(doubleOpt(Some(2))) //4
  println(doubleOpt(None())) //None

  /**
   * Implement a method that takes an Optional[Boolean] and invert
   * its value (if not empty)
   */

  def negOpt(opt: Option[Boolean]): Option[Boolean] = opt match
    case None() => None()
    case Some(a) => Some(!a)

  println("****** Neg Opt ******")
  println(negOpt(Some(true))) //false
  println(negOpt(Some(false))) //true
  println(negOpt(None())) //None

  /**
   * How would you write a generalisation of the two?
   */

  def doubleOptDRY(opt: Option[Int]): Option[Int] = transformOpt(opt)(_ * 2)

  def negOptDRY(opt: Option[Boolean]): Option[Boolean] = transformOpt(opt)(!_)

  def transformOpt[A](opt: Option[A])(f: A => A): Option[A] = opt match
      case None() => None()
      case Some(a) => Some(f(a))

  println("****** Generalized Opt ******")
  println(doubleOptDRY(Some(25))) //50
  println(negOptDRY(Some(false))) //true
  println(transformOpt(Some(5))(_+1)) //6
}
