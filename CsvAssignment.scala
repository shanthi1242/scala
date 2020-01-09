package learning.exceptionHandling.shanthi

import scala.collection.mutable

object CsvAssignment {

  def findTotalAmount(): mutable.HashMap[String, Double] = {
    val source = io.Source.fromFile("D:/Scala/test.csv")
    val customerMap: mutable.HashMap[String, Double] = new mutable.HashMap()
    for (lines <- source.getLines()) {
      val cols = lines.split(",")
      var price: Double = cols(3).toDouble
      if (customerMap.contains(cols(1))) {
        price = price + customerMap(cols(1))
        customerMap.put(cols(1), price)
      } else {
        customerMap.put(cols(1), price)
      }
    }
    customerMap
  }

  def main(args: Array[String]): Unit = {
    val customerAmount = findTotalAmount()
    customerAmount.foreach(f => println(f))
  }
}
