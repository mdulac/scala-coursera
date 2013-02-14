object Test {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(63); val res$0 = 
  "Mathieu".map( c => if(c.isLower) c.toUpper else c.toLower );System.out.println("""res0: String = """ + $show(res$0));$skip(72); val res$1 = 
  Stream('m', 'a', 't', 'h', 'i', 'e', 'u').foldLeft("")((a, b) => a+b);System.out.println("""res1: java.lang.String = """ + $show(res$1));$skip(56); 
 val stream = Stream('m', 'a', 't', 'h', 'i', 'e', 'u');System.out.println("""stream  : scala.collection.immutable.Stream[Char] = """ + $show(stream ));$skip(51); 
 
 def from(i: Int): Stream[Int] = i #:: from(i+1);System.out.println("""from: (i: Int)Stream[Int]""");$skip(42); val res$2 = 
 from(0).take(1).map( _*3 )       .toList;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(59); 
  def apply(f: => Int => Int)(i: Int): Int = {
  	f(i)
  };System.out.println("""apply: (f: => Int => Int)(i: Int)Int""");$skip(104); 
      
      def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter(_ % s.head != 0) );System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(65); 
                                     val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(39); val res$3 = 
               primes.take(100).toList;System.out.println("""res3: List[Int] = """ + $show(res$3))}
                                                  
}