package com.topherian.adventOfCode

import scala.io.Source

object Day3 {

  def main(args: Array[String]): Unit = {
    val fileStream = getClass.getResourceAsStream("/Day3Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    computePower(input)
  }

  def computePower(input: List[String]): Int = {
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
    val gammaBinary = generateBinary(binaryMap,inputSize)
    val gamma = Integer.parseInt(gammaBinary,2)
    val epsilon =Integer.parseInt(flipBinary(gammaBinary), 2)
    gamma*epsilon
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

  def flipBinary(binaryString: String): String = {
    val flipped = binaryString
    val flipped1 = flipped.replace('1', 'x').
      replace('0','1').
      replace('x', '0')
    flipped1
  }
}
