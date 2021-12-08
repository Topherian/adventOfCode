package com.topherian.adventOfCode

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

import scala.io.Source

@RunWith(classOf[JUnitRunner])
class Day3Tests extends AnyFunSuite {

  test("Calculate diagnostic with Sample input") {
    val fileStream = getClass.getResourceAsStream("/Day3SampleSmall.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val binaryMap:scala.collection.mutable.Map[Int,Int] = scala.collection.mutable.Map[Int, Int]()
    val inputSize = input.size / 2
    for(line<-input) {
      var column = 0
      for(c<-line) {
        var currentCount: Int = binaryMap.getOrElse(column, 0)
        if (c.equals('1')) {
          currentCount += 1
          binaryMap.put(column,currentCount)
        } else {
          binaryMap.put(column,currentCount)
        }
        column+=1
      }
    }
    assert(Integer.parseInt(generateBinary(binaryMap,inputSize),2) == 22)
  }

  test("Calculate diagnostic with Actual input") {
    val fileStream = getClass.getResourceAsStream("/Day3Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    val binaryMap:scala.collection.mutable.Map[Int,Int] = scala.collection.mutable.Map[Int, Int]()
    val inputSize = input.size / 2
    for(line<-input) {
      var column = 0
      for(c<-line) {
        var currentCount: Int = binaryMap.getOrElse(column, 0)
        if (c.equals('1')) {
          currentCount += 1
          binaryMap.put(column,currentCount)
        } else {
          binaryMap.put(column,currentCount)
        }
        column+=1
      }
    }
    assert(Integer.parseInt(generateBinary(binaryMap,inputSize),2) == 22)
  }

  def generateBinary(binaryMap: scala.collection.mutable.Map[Int,Int], threshold: Int): String = {
    val binaryNumber = new StringBuilder()
    binaryMap.foreach(count =>
      if (count._2 > threshold) {
        binaryNumber.append("1")
      }
      else {
        binaryNumber.append("0")
      }
    )
    binaryNumber.toString()
  }
}
