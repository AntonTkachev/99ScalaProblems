package TreeParser

import java.io.{File, PrintWriter}

import scala.io.Source

object Read extends App {

  //  new PrintWriter(new File("TreeParser/first.tree"))

//  Source.fromURL(getClass.getResource("/first.tree"))

  for (line <- Source.fromFile("C:\\Projects\\99ScalaProblems\\src\\main\\resources\\first.tree").getLines()) {
    println(line)
  }


}
