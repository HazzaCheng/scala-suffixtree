package com.wanghuanming.suffixtree

import org.scalatest.FunSuite

/**
  * Created by ming on 17-4-6.
  */
class RangeSubStringTest extends FunSuite {

  test("take") {
    val s = RangeSubString("hello", 1, 5, "label", 0)
    assert("el" === s.take(2).mkString)
    assert("ello" === s.take(10).mkString)
  }

  test("startsWith") {
    val s = RangeSubString("hello")
    assert(s.startsWith(RangeSubString("ello"), 1))
    assert(!s.startsWith(RangeSubString("ellosdf"), 1))
    assert(!s.startsWith(RangeSubString("ello"), 2))
  }

  test("commonPrefix") {
    val cases = Iterable(
      ("hello", "helle", "hell"),
      ("a", "b", ""),
      ("abcd", "abc", "abc"),
      ("a", "abcd", "a"),
      ("abc", "abc", "abc")
    )
    for (c <- cases) {
      val s1 = RangeSubString(c._1)
      val s2 = RangeSubString(c._2)
      val common = s1.commonPrefix(s2)
      assert(c._3 === common.mkString)
    }
  }

}
