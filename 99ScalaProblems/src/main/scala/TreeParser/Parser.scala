package TreeParser

import scala.collection.mutable.ListBuffer

trait Parser {

  val example = "TREE is optional list-of LINE\nLINE is\n\toptional INDENT\n\toptional NODES\n\tNEW-LINE\n\nNODES is\n\toptional list-of SYMBOL\n\toptional DATA\n\twith-delimiter SPACE\n\nSYMBOL is list-of byte except SPECIAL\n\nDATA is\n\tDATA-PREFIX\n\toptional list-of byte except NEW-LINE\n\nSPECIAL is any-of\n\tNEW-LINE\n\tDATA-PREFIX\n\tINDENT\n\tSPACE\n\nNEW-LINE is octet \\0A\nINDENT is list-of octet \\09\nDATA-PREFIX is octet \\5C\nSPACE is list-of octet \\20"

  // fixme настолько сыро что я ноги обмочил
  def parser(str: String): String = {
    val listWithOctet = new ListBuffer[String]()
    val listWithValue = new ListBuffer[String]()
    var endStr = str
    endStr.split("\n").foreach({ line =>
      val xx = line.split(" ")
      xx.foreach({ el =>
        if (el == "octet") {
          endStr = endStr.replace(s"\n$line", "")
          listWithOctet += xx.head
          listWithValue += xx.last
        }
      })
    })
    for (num <- listWithOctet.indices) {
      endStr = endStr.replaceAll(listWithOctet(num), listWithValue(num))
    }
    endStr
  }

  parser(example)

  implicit class Test(path: String) {
    def \(str: String) = {
      val res = new StringBuilder()
      var flag = false
      path.split("\n").foreach({ line =>
        if (line.split(" ").head == str) {
          res.append(s"$line\n")
          flag = true
        }
        else if (flag && line.startsWith("\t")) res.append(s"$line\n")
        else if (flag && !line.startsWith("\t")) flag = false
      })
      res.toString()
    }
  }

}
