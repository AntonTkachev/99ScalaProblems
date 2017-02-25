package model

object TestModelParser extends App {

  val example =
    """TAG
      |	first =52
      |	first =11
      |	first2
      |
      |TAG1
      |	second
      |	second1
      |
      |	TAG2
      |		fourth =1
      |		third1
      |
      |			TAG3
      |				fourth =11
      |				fourth =213
      |				fourth2
      |				fourth3
      |
      |TAG4
      |	fifth
      |	fifth1
      | """.stripMargin

  val p = new Parser

  val res = p.parse(example)

  Parser.getRoot.foreach(println)

  println(Parser.getTag("TAG3"))

  Parser.getValue("fourth").foreach(println)

  println(Parser.getChildren)
}
