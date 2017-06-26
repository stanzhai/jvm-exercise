package site.stanzhai.exercise.serialization

/**
  * Created by stan on 2017/1/8.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val testList = List.range(1, 3)
    val fileClassLoader = new FileClassLoader()
    val closure = FileSerializer.readObjectWithClassLoader("c.ser", fileClassLoader).asInstanceOf[Function1[Int, Int]]
    println(testList.map(closure).sum)
  }
}
