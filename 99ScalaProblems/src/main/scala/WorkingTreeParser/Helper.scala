package WorkingTreeParser

trait Helper {
  val exampleWithManyRootTag =
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

  val exampleWithOneRootTag =
    """TAG
      |	first =52
      |	first =11
      |	first2
      |
      |	TAG2
      |		second =1
      |		second1
      |
      |		TAG4
      |			fourth =11
      |			fourth =213
      |			fourth2
      |			fourth3
      | """.stripMargin
}
