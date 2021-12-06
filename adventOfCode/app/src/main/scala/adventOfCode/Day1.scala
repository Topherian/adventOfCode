package adventOfCode

import scala.io.Source

object Day1 {

  def main(args: Array[String]): Unit = {
    val fileStream = getClass.getResourceAsStream("/Day1Actual.txt")
    sonarSweep(Source.fromInputStream(fileStream).getLines)
  }

  def sonarSweep(input: Iterator[String]): Int = {
    var counter = 0
    var previousDepth = 0
    var initialDive = true
    input.foreach { line =>
      val depth = line.toInt
      if (depth > previousDepth && !initialDive)
        counter+=1
      previousDepth = depth
      initialDive = false
    }
    println("Depth Measurement Increase Count : " + counter)
    counter
  }
}
