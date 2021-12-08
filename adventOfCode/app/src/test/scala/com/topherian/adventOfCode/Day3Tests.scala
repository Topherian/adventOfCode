package com.topherian.adventOfCode

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

import scala.io.Source

@RunWith(classOf[JUnitRunner])
class Day3Tests extends AnyFunSuite {

  test("Calculate power with Sample input") {
    val fileStream = getClass.getResourceAsStream("/Day3Sample.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    assert(Day3.computePower(input) == 198)
  }

  test("Calculate power with Actual input") {
    val fileStream = getClass.getResourceAsStream("/Day3Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    assert(Day3.computePower(input) == 2967914)
  }

}
