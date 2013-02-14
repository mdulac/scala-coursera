object slides {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(59); 
  println("Welcome to the Scala worksheet");$skip(32); 
  
  val x = new Rational(1, 3);System.out.println("""x  : Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : Rational = """ + $show(z ));$skip(15); val res$0 = 
  
  x - y - z;System.out.println("""res0: Rational = """ + $show(res$0));$skip(8); val res$1 = 
  y + y;System.out.println("""res1: Rational = """ + $show(res$1));$skip(10); val res$2 = 
  y max z;System.out.println("""res2: Rational = """ + $show(res$2));$skip(21); val res$3 = 
  
  new Rational(2);System.out.println("""res3: Rational = """ + $show(res$3))}
  
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