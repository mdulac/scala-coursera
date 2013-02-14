object currying {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	if(a > b) 1
  	else f(a) * product(f)(a+1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$0 = 
  
  product(x => x)(1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(60); 
  
  def fact(n: Int): Int = {
  	product(x => x)(1, n)
  };System.out.println("""fact: (n: Int)Int""");$skip(13); val res$1 = 
  
  fact(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(254); 
  
  // def sum(f: Int => Int, a: Int, b: Int) = f(a) + f(b)
  // def sumInt(a: Int, b:Int) = sum(x => x, a, b)
  // sumInt(12, 13)
  
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int = {
  			f(a) + f(b)
  	}
  	sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(76); val res$2 = 
  
  // def sum2 = sum(x => x)
  // sum2(14, 6)
  // =
  sum(x => x)(14, 6);System.out.println("""res2: Int = """ + $show(res$2));$skip(82); val res$3 = 
  
  // def sum3 = sum(x => x * x)
  // sum3(3, 2)
  // =
  sum(x => x * x)(3, 2);System.out.println("""res3: Int = """ + $show(res$3));$skip(39); 
  
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(20); val res$4 = 
  sum (cube) (4, 5);System.out.println("""res4: Int = """ + $show(res$4));$skip(67); 
  
  def otherSum(f: Int => Int)(a: Int, b: Int):Int = f(a) + f(b);System.out.println("""otherSum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); 
  def c = otherSum (cube)_;System.out.println("""c: => (Int, Int) => Int""");$skip(10); val res$5 = 
  c(4, 5);System.out.println("""res5: Int = """ + $show(res$5));$skip(52); 
  
  def f(a: Int)(b: Int)(c: Int): Int = a + b + c;System.out.println("""f: (a: Int)(b: Int)(c: Int)Int""");$skip(19); 
  
  def a = f(3)_;System.out.println("""a: => Int => (Int => Int)""");$skip(15); 
  def b = a(6);System.out.println("""b: => Int => Int""");$skip(7); val res$6 = 
  b(1);System.out.println("""res6: Int = """ + $show(res$6));$skip(16); val res$7 = 
  
  f(3)(6)(1);System.out.println("""res7: Int = """ + $show(res$7))}
 }