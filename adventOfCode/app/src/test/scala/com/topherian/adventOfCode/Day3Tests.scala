package com.topherian.adventOfCode

import com.topherian.adventOfCode.domain.BinaryStore
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

  test("Calculate Oxygen Generator Rating with sample input") {
    val fileStream = getClass.getResourceAsStream("/Day3Sample.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val oxygen : Int = Day3.getOxygenGeneratorRating(input, '1',0)
    assert(oxygen == 23)
  }

  test("Calculate CO2 Rating with sample input") {
    val fileStream = getClass.getResourceAsStream("/Day3Sample.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val co2 : Int = Day3.getCO2Rating(input, '1',0)
    assert(co2 == 10)
  }

  test("Calculate Life Rating with sample input") {
    val fileStream = getClass.getResourceAsStream("/Day3Sample.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val co2 : Int = Day3.computeLifeRating(input)
    assert(co2 == 230)
  }

  test("Calculate Life Rating with actual input") {
    val fileStream = getClass.getResourceAsStream("/Day3Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val co2 : Int = Day3.computeLifeRating(input)
    assert(co2 == 7041258)
  }
}
