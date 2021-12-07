package com.topherian.adventOfCode

import scala.io.Source

object Day2 {

  def main(args: Array[String]): Unit = {
    val fileStream = getClass.getResourceAsStream("/Day2Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines().toList.map((s: String) => s.split("\\ "))
    depthCalculator(input)
  }


  def depthCalculator(input: List[Array[String]]): Int = {
    var horizontal: Int = 0
    var depth: Int = 0
    for(line<-input) {
      line(0) match {
        case "forward" => horizontal+= line(1).toInt
        case "down" => depth+= line(1).toInt
        case "up" => depth-= line(1).toInt
      }
    }
    horizontal*depth
  }

  def depthCalculatorWithAim(input: List[Array[String]]): Int = {
    var horizontal: Int = 0
    var depth: Int = 0
    var aim: Int = 0
    for(line<-input) {
      line(0) match {
        case "forward" => {
          horizontal+= line(1).toInt
          if (aim > 0) {
            depth = depth + (aim * line(1).toInt)
          }
        }
        case "down" => {
          aim += line(1).toInt
        }
        case "up" => {
          aim -= line(1).toInt
        }
      }
    }
    horizontal*depth
  }
}
