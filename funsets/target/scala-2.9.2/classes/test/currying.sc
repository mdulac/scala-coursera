object currying {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	if(a > b) 1
  	else f(a) * product(f)(a+1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x)(1, 10)                          //> res0: Int = 3628800
  
  def fact(n: Int): Int = {
  	product(x => x)(1, n)
  }                                               //> fact: (n: Int)Int
  
  fact(5)                                         //> res1: Int = 120
  
  // def sum(f: Int => Int, a: Int, b: Int) = f(a) + f(b)
  // def sumInt(a: Int, b:Int) = sum(x => x, a, b)
  // sumInt(12, 13)
  
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int = {
  			f(a) + f(b)
  	}
  	sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  // def sum2 = sum(x => x)
  // sum2(14, 6)
  // =
  sum(x => x)(14, 6)                              //> res2: Int = 20
  
  // def sum3 = sum(x => x * x)
  // sum3(3, 2)
  // =
  sum(x => x * x)(3, 2)                           //> res3: Int = 13
  
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  sum (cube) (4, 5)                               //> res4: Int = 189
  
  def otherSum(f: Int => Int)(a: Int, b: Int):Int = f(a) + f(b)
                                                  //> otherSum: (f: Int => Int)(a: Int, b: Int)Int
  def c = otherSum (cube)_                        //> c: => (Int, Int) => Int
  c(4, 5)                                         //> res5: Int = 189
  
  def f(a: Int)(b: Int)(c: Int): Int = a + b + c  //> f: (a: Int)(b: Int)(c: Int)Int
  
  def a = f(3)_                                   //> a: => Int => (Int => Int)
  def b = a(6)                                    //> b: => Int => Int
  b(1)                                            //> res6: Int = 10
  
  f(3)(6)(1)                                      //> res7: Int = 10
 }