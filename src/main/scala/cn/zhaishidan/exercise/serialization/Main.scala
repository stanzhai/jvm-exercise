package cn.zhaishidan.exercise.serialization

/**
  * Created by stan on 2017/1/8.
  */
object Main {

  def main(args: Array[String]): Unit = {
    /*
    val task = new SimpleTask()
    task.run()
    Serializer.writeObjectToFile(task, "task.ser")
    */

    /*
    val task = Serializer.readObjectFromFile("task.ser").asInstanceOf[Task]
    task.run()
    */

    val testList = List.range(1, 3)

    /*
    println(testList.map({ x => x + 1}).sum)
    Serializer.writeObjectToFile({(x: Int) => x + 1}, "closure.ser")
    */

    val fun = FileSerializer.readObjectFromFile("closure.ser").asInstanceOf[(Int) => Int]
    println(testList.map(fun).sum)
  }
}
