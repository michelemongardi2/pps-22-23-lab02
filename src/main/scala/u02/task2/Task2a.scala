package u02.task2

object Task2a extends App {

  val positiveVal: Int => String = _ match
    case x if x >= 0 => "positive"
    case _ => "negative"

  println(positiveVal(10))
  println(positiveVal(0))
  println(positiveVal(-5))

  def positiveDef(n: Int): String = n match
    case n if n >= 0 => "positive"
    case _ => "negative"

  println(positiveDef(4))
  println(positiveDef(0))
  println(positiveDef(-2))

  val neg: (String => Boolean) => (String => Boolean) = f => (s => !f(s))

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = neg(empty) // which type of notEmpty? (String => Boolean)

  println(empty("Hello")) //false
  println(empty("")) //true
  println(notEmpty("foo")) // true
  println(notEmpty ("")) // false
  println(notEmpty ("foo") && !notEmpty("")) // true.. a comprehensive test

}
