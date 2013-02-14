package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
  }

  def size(set: TweetSet): Int = {
    if (set.isEmpty) 0
    else 1 + size(set.tail)
  }

  ignore("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  ignore("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  ignore("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }
  
  test("filter: 321 on set") {
    new TestSets {
      val t1 = new Tweet("a", "a body", 7)
      val t2 = new Tweet("b", "b body", 9)
      val t3 = new Tweet("c", "c body", 321)
      val t4 = new Tweet("d", "d body", 9)
      val t5 = new Tweet("e", "e body", 400)
      val set = new Empty().incl(t3).incl(t1)//.incl(t2).incl(t3).incl(t4).incl(t5)
      assert(set.contains(t1))
//      assert(set.contains(t2))
      assert(set.contains(t3))
//      assert(set.contains(t4))
//      assert(set.contains(t5))
//      assert(size(set) == 1);
      assert(size(set) == 2)
      assert(size(set.filter(tw => tw.retweets > 320)) === 1)
    }
  }

  ignore("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  ignore("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  ignore("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("ascending: set5") {
    new TestSets {
      val trends = set5.ascendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user === "c")
    }
  }
  
  ignore("google vs apple") {
    GoogleVsApple.appleTweets
  }
}
