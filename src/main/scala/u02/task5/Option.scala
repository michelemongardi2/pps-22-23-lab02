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
}
