object Tutorial9_Q2 {
  class Rational(num: Int, den: Int) {
    require(den != 0, "Denominator cannot be zero")

    private val gcdValue: Int = gcd(num.abs, den.abs)
    val numer: Int = num / gcdValue
    val denom: Int = den / gcdValue

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    def -(that: Rational): Rational = {
      new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    }

    override def toString: String = s"$numer/$denom"
  }

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x - y - z
    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"$x - $y - $z = $result")
  }
}
