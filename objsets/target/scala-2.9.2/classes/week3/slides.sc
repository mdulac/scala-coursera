object slides {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
  
  x - y - z                                       //> res0: Rational = -79/42
  y + y                                           //> res1: Rational = 10/7
  y max z                                         //> res2: Rational = 3/2
  
  new Rational(2)                                 //> res3: Rational = 2/1
  
}

class Rational(x: Int, y: Int) {
  	require(y != 0, "denominator must be nonzero")
  
  	def this(x: Int) = this(x, 1)
  
  	private def gcd(a: Int, b:Int): Int = if(b == 0) a else gcd(b, a % b)
  	def numer = x;
  	def denom = y;
  	
  	def < (that: Rational): Boolean = numer * that.denom < that.numer * denom
  	
  	def max(that: Rational) = if(this < that) that else this
  	
  	def + (that: Rational) =
  		new Rational(
  			numer * that.denom + that.numer * denom,
  			denom * that.denom)
  	
  	def unary_- : Rational = new Rational(-numer, denom)
  	
  	def - (that: Rational) = this + -that
  	
  	override def toString = {
  		val g = gcd(x, y)
  		numer/g + "/" + denom/g
  	}
  	
}