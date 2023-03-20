package u02.task3

import scala.annotation.tailrec

object GCD extends App{

  def gcd(a: Int, b: Int): Int = a match
    case a if (a % b) == 0 => b
    case a if (a > b) => gcd(b, a % b)
    case _ if (b > a) => gcd(a, b % a)

  @tailrec
  def tailrecGcd(a: Int, b: Int): Int = b match
    case 0 => a
    case _ => tailrecGcd(b, (a % b))

  println("******** GCD ********")
  println(gcd(12, 8)) // 4
  println(gcd(14, 7)) // 7
  println(gcd(12, 32)) // 4
  println(gcd(58, 100)) // 2
  println(gcd(13, 17)) // 1

  println("******** GCD tailrec ********")
  println(tailrecGcd(12, 8)) // 4
  println(tailrecGcd(14, 7)) // 7
  println(tailrecGcd(12, 32)) // 4
  println(tailrecGcd(58, 100)) // 2
  println(tailrecGcd(13, 17)) // 1
}
