package forcomp

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Anagrams._

@RunWith(classOf[JUnitRunner])
class AnagramsSuite extends FunSuite {

  test("wordOccurrences: abcd") {
    assert(wordOccurrences("abcd") === List(('a', 1), ('b', 1), ('c', 1), ('d', 1)))
  }

  test("wordOccurrences: Robert") {
    assert(wordOccurrences("Robert") === List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1)))
  }

  test("sentenceOccurrences: abcd e") {
    assert(sentenceOccurrences(List("abcd", "e")) === List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1)))
  }

  test("sentenceOccurrences: Roberto Carlos") {
    assert(sentenceOccurrences(List("Roberto", "Car", "los")) === List(('a', 1), ('b', 1), ('c', 1), ('e', 1), ('l', 1), ('o', 3), ('r', 3), ('s', 1), ('t', 1)))
  }

  test("dictionaryByOccurrences.get: eat") {
    assert(dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1))).map(_.toSet) === Some(Set("ate", "eat", "tea")))
  }

  test("word anagrams: married") {
    assert(wordAnagrams("married").toSet === Set("married", "admirer"))
  }

  test("word anagrams: player") {
    assert(wordAnagrams("player").toSet === Set("parley", "pearly", "player", "replay"))
  }
  
  test("word anagrams: zodiac") {
    assert(wordAnagrams("zodiac".reverse).toSet === Set("zodiac"))
  }

  test("subtract: lard - r") {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val r = List(('r', 1))
    val lad = List(('a', 1), ('d', 1), ('l', 1))
    assert(subtract(lard, r) === lad)
  }
  
  test("jimmy - myc") {
    val jimmy = List(('j', 1), ('i', 1), ('m', 2), ('y', 1))
    val my = List(('m', 1), ('y', 1))
    val jim = List(('j', 1), ('i', 1), ('m', 1))
    assert(subtract(jimmy, my) === jim)
  }

  test("combinations: []") {
    assert(combinations(Nil) === List(Nil))
  }

  test("combinations: abba") {
    val abba = List(('a', 2), ('b', 2))
    val abbacomb = List(
      List(),
      List(('a', 1)),
      List(('a', 2)),
      List(('b', 1)),
      List(('a', 1), ('b', 1)),
      List(('a', 2), ('b', 1)),
      List(('b', 2)),
      List(('a', 1), ('b', 2)),
      List(('a', 2), ('b', 2)))
    assert(combinations(abba).toSet === abbacomb.toSet)
  }
  
  ignore("combinations: yes man") {
    val yesman = List(('a', 1), ('e', 1), ('m', 1), ('n', 1), ('s', 1), ('y', 1))
    println(combinations(yesman).toSet)
  }
  
  ignore("combinations: aaa") {
    val abcd = List(('a', 1), ('b', 1), ('c', 1), ('d', 1))
    println(combinations(abcd).toSet)
  }

  ignore("combinations: linux rulez") {
    val linuxRules = List(('e', 1), ('i', 1), ('l', 1), ('n', 1), ('r', 1), ('u', 2), ('x', 1), ('y', 1), ('z', 1))
    combinations(linuxRules)
  }
  
  ignore("sentence anagrams: []") {
    val sentence = List()
    assert(sentenceAnagrams(sentence) === List(Nil))
  }

  ignore("sentence anagrams: Lin nil") {
    val sentence = List("Lin", "nil")
    println(sentenceAnagrams(sentence))
  }
  
  test("sentence anagrams: my en") {
    val sentence = List("my", "en")
    println( sentenceAnagrams(sentence) )
  }
  
  ignore("sentence anagrams: Linux rulez") {
    val sentence = List("Linux", "Rulez")
    val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez"))
    assert(sentenceAnagrams(sentence).toSet === anas.toSet)
  }

}
