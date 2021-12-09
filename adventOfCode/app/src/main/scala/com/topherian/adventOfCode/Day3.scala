package com.topherian.adventOfCode

import com.topherian.adventOfCode.domain.BinaryStore
import jdk.internal.util.xml.impl.Input

import scala.collection.mutable.ListBuffer
import scala.io.Source

object Day3 {

  def main(args: Array[String]): Unit = {
    val fileStream = getClass.getResourceAsStream("/Day3Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList
    computePower(input)
  }

  //returns column counts of a given binary number across a set of input strings
  def getBinaryMap(input: List[String], binaryChar: Char): scala.collection.mutable.Map[Int,Int] = {
    val binaryMap:scala.collection.mutable.Map[Int,Int] = scala.collection.mutable.Map[Int, Int]()
    for(line<-input) {
      var column = 0
      for(c<-line) {
        var currentCount: Int = binaryMap.getOrElse(column, 0)
        if (c.equals(binaryChar)) {
          currentCount += 1
          binaryMap.put(column,currentCount)
        } else {
          binaryMap.put(column,currentCount)
        }
        column+=1
      }
    }
    binaryMap
  }

  def calculateOxygenList(input: List[String], binaryChar: Char, binaryPosition: Int): List[String] = {
    val binaryMap: scala.collection.mutable.Map[Int, BinaryStore] = scala.collection.mutable.Map[Int, BinaryStore]()
    for (line <- input) {
      var column = 0
      for (c <- line) {
        val currentList: BinaryStore = binaryMap.getOrElse(column, BinaryStore(new ListBuffer[String], new ListBuffer[String]))
        if (c.equals(binaryChar)) {
          currentList.one += line
          binaryMap.put(column, currentList)
        } else {
          currentList.zero += line
          binaryMap.put(column, currentList)
        }
        column += 1
      }
    }
    val binaryStore: BinaryStore = binaryMap.getOrElse(binaryPosition, BinaryStore(new ListBuffer[String], new ListBuffer[String]))
    if (binaryStore.one.toList.size >= binaryStore.zero.toList.size) {
      binaryStore.one.toList
    }
    else {
       binaryStore.zero.toList
    }
  }

  def calculateCO2RatingList(input: List[String], binaryChar: Char, binaryPosition: Int): List[String] = {
    val binaryMap: scala.collection.mutable.Map[Int, BinaryStore] = scala.collection.mutable.Map[Int, BinaryStore]()
    for (line <- input) {
      var column = 0
      for (c <- line) {
        val currentList: BinaryStore = binaryMap.getOrElse(column, BinaryStore(new ListBuffer[String], new ListBuffer[String]))
        if (c.equals(binaryChar)) {
          currentList.one += line
          binaryMap.put(column, currentList)
        } else {
          currentList.zero += line
          binaryMap.put(column, currentList)
        }
        column += 1
      }
    }
    val binaryStore: BinaryStore = binaryMap.getOrElse(binaryPosition, BinaryStore(new ListBuffer[String], new ListBuffer[String]))
    if (binaryStore.one.toList.size >= binaryStore.zero.toList.size) {
      binaryStore.zero.toList
    }
    else {
      binaryStore.one.toList
    }
  }

  def getOxygenGeneratorRating(input: List[String], binaryChar: Char, binaryPosition: Int): Int = {
    if (input.size == 1){
      Integer.parseInt(input(0),2)
    }
    else {
      val processedList: List[String] = calculateOxygenList(input, binaryChar, binaryPosition)
      val incPosition : Int = binaryPosition + 1
      getOxygenGeneratorRating(processedList,'1', incPosition)
    }
  }

  def getCO2Rating(input: List[String], binaryChar: Char, binaryPosition: Int): Int = {
    if (input.size == 1) {
      Integer.parseInt(input(0), 2)
    }
    else {
      val processedList: List[String] = calculateCO2RatingList(input, binaryChar, binaryPosition)
      val incPosition: Int = binaryPosition + 1
      getCO2Rating(processedList, '1', incPosition)
    }
  }

  def computeLifeRating(input: List[String]): Int = {
    Day3.getCO2Rating(input,'1',0) * Day3.getOxygenGeneratorRating(input, '1',0)
  }

  def computePower(input: List[String]): Int = {
    val inputSize = input.size / 2
    val gammaBinary = generateBinary(getBinaryMap(input,'1'),inputSize)
    val gamma = Integer.parseInt(gammaBinary,2)
    val epsilon = Integer.parseInt(flipBinary(gammaBinary), 2)
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
    val flipped1 = binaryString.replace('1', 'x').
      replace('0','1').
      replace('x', '0')
    flipped1
  }
}
