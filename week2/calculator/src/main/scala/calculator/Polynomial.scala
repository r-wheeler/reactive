package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    Signal{
      (b() * b() - 4 * a() * c())
    }
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    Signal{
      delta() match {
        case n if n < 0  => Set()
        case n if n == 0 =>
          val root = (-1 * b()) / (2 * a())
          Set(root)
        case n if n > 0 =>
          val root1 = (-b() - scala.math.sqrt(delta()) / (2 * a()))
          val root2 = (-b() + scala.math.sqrt(delta()) / (2 * a()))
          Set(root1,root2)
      }

    }
  }
}
