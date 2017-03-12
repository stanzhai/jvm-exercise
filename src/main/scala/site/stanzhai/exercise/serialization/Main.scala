package site.stanzhai.exercise.serialization

/**
  * Created by stan on 2017/1/8.
  */
object Main {

  def main(args: Array[String]): Unit = {
    /*
    val task = new SimpleTask()
    task.run()
    FileSerializer.writeObjectToFile(task, "task.ser")
    ClassManipulator.saveClassFile(task)
    */

    val fileClassLoader = new FileClassLoader()
    /*
    val task = FileSerializer.readObjectFromFile("task.ser", fileClassLoader).asInstanceOf[Task]
    task.run()
    */

    val testList = List.range(1, 3)

    /*
    val closure = {(x: Int) => x + 1}
    println(testList.map(closure).sum)
    FileSerializer.writeObjectToFile(closure, "closure.ser")
    ClassManipulator.saveClassFile(closure)
    */

    val fun = FileSerializer.readObjectFromFile("closure.ser", fileClassLoader).asInstanceOf[(Int) => Int]
    println(testList.map(fun).sum)
  }
}
