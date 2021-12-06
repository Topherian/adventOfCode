package com.topherian.adventOfCode

import scala.io.Source

object Day1 {

  def main(args: Array[String]): Unit = {
    val fileStream = getClass.getResourceAsStream("/Day1Actual.txt")
    val input = Source.fromInputStream(fileStream).getLines.toList.map((s: String) => s.toInt)
    sonarSweep(input)
    slidingSonarSweep(input, 3)
  }

  def sonarSweep(input: List[Int]): Int = {
    var counter = 0
    var previousDepth = 0
    var initialDive = true
    input.foreach { line =>
      if (line > previousDepth && !initialDive)
        counter += 1
      previousDepth = line
      initialDive = false
    }
    println("Depth Measurement Increase Count : " + counter)
    counter
  }

  def slidingSonarSweep(input: List[Int], windowLength: Int): Int = {
    val window : List[Int] = input.sliding(windowLength).toList.map(_.sum)
    sonarSweep(window)
  }
}
