package u02.task4

object Geometric extends App {

  enum Shape:
    case Rectangle(base: Double, height: Double)
    case Circle(radius: Double)
    case Square(side: Double)

  object Shape:
    import math.Pi

    def perimeter(shape: Shape): Double = shape match
      case Rectangle(base, height) => (2 * base) + (2 * height)
      case Circle(radius) => radius * 2 * Pi
      case Square(side) => 4 * side

    def contains(shape: Shape, point: (Double, Double)): Boolean = shape match
      case Rectangle(base, height) =>
        val (x, y) = point
        ((x >= 0) && (x <= base)) && ((y >= 0) && (y <= height))
      case Circle(radius) =>
        val (x, y) = point
        val distance = math.sqrt(x * x + y * y)
        distance <= radius
      case Square(side) =>
        val (x, y) = point
        ((x >= 0) && (x <= side)) && ((y >= 0) && (y <= side))

  import Shape.*

  val rectanglePerimeter: Rectangle => Double = rectangle => perimeter(rectangle)
  val rectangle: (Double, Double) => Rectangle = (x, y) => Rectangle(x, y)

  println("****** Perimeter Test ******")
  println(rectanglePerimeter(rectangle(10, 20))) //60
  println(perimeter(Rectangle(20.0, 40.0))) //120
  println(perimeter(Circle(12))) //75.40
  println(perimeter(Square(10))) //40

  println("****** Contain Test ******")
  println(contains(rectangle(25, 15),(2, 0))) //true
  println(contains(Circle(10.0), (20, 30))) //false
  println(contains(Square(12), (-5, 0))) //false
  println(contains(Square(20), (8, 10))) //false
}

