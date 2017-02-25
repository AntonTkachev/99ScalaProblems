import java.io.{File, FileWriter}

object newDir extends App {

  val path = ""

  def createDir(p: String) = {

    val file = new File(p)
    try {
      if (!file.canWrite) file.setWritable(true)

      if (!file.exists()) {
        file.mkdir()
        for (num <- 0 to 5) {
          val f = new FileWriter(s"$p\\$num.txt", false)
          f.close()
        }
      }
      else println("Папка уже существует")
    }
    catch {
      case e: Throwable => println(s"Что то пошло не так ", e)
    }
  }

  //  createDir("C:\\Projects\\IdeaProjects\\esb\\esb_monitoring\\kafka-transport-2\\src\\test\\scala\\newPapka")


  def deleteDir(pathToDelDir: String) = {
    new File(pathToDelDir) match {
      case deleteFile if !deleteFile.exists() => println("Данной директории не существует!")

      case deleteFile if !deleteFile.canWrite => println("Не хватает прав для удаления!")

      case deleteFile if deleteFile.exists() && deleteFile.canWrite =>
        if (deleteFile.isDirectory) {
          deleteFile.listFiles().foreach(_.delete())
        }
        deleteFile.delete()
    }
  }

  deleteDir("C:\\Projects\\IdeaProjects\\esb\\esb_monitoring\\kafka-transport-2\\src\\test\\scala\\newPapka\\2.txt")

  //  val file = new File(path)
  //  if (file.exists()) {
  //    file.mkdirs()
  //  }
}
