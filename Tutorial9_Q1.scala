import scala.io.StdIn

object Tutorial9_Q1 {
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must be non-zero")

    val numer: Int = n
    val denom: Int = d

    def neg: Rational = new Rational(-numer, denom)

    override def toString: String = s"$numer/$denom"
  }

  def main(args: Array[String]): Unit = {
    println("Enter numerator:")
    val numerator = StdIn.readInt()

    println("Enter denominator:")
    val denominator = StdIn.readInt()

    val rationalNumber = new Rational(numerator, denominator)
    val negNumber = rationalNumber.neg

    println(s"The negation of $rationalNumber is $negNumber")
  }
}
