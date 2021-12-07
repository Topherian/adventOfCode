/*
 * This Scala Testsuite was generated by the Gradle 'init' task.
 */
package com.topherian.adventOfCode

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

import scala.io.Source

@RunWith(classOf[JUnitRunner])
class Day2Tests extends AnyFunSuite {

  test("Calculate depth with Sample input") {
    val fileStream = getClass.getResourceAsStream("/Day2Sample.txt")
    val lines: List[Array[String]] = Source.fromInputStream(fileStream).getLines().toList.map((s: String) => s.split("\\ "))
    assert(Day2.depthCalculator(lines) == 150)
  }

  test("Calculate depth with Actual input") {
    val fileStream = getClass.getResourceAsStream("/Day2Actual.txt")
    val lines: List[Array[String]] = Source.fromInputStream(fileStream).getLines().toList.map((s: String) => s.split("\\ "))
    assert(Day2.depthCalculator(lines) == 2073315)
  }

  test("Calculate depth with aim with Sample input") {
    val fileStream = getClass.getResourceAsStream("/Day2Sample.txt")
    val lines: List[Array[String]] = Source.fromInputStream(fileStream).getLines().toList.map((s: String) => s.split("\\ "))
    assert(Day2.depthCalculatorWithAim(lines) == 900)
  }

  test("Calculate depth with aim with Actual input") {
    val fileStream = getClass.getResourceAsStream("/Day2Actual.txt")
    val lines: List[Array[String]] = Source.fromInputStream(fileStream).getLines().toList.map((s: String) => s.split("\\ "))
    assert(Day2.depthCalculatorWithAim(lines) == 1840311528)
  }

}
