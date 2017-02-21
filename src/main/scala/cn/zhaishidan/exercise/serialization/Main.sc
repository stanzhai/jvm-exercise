import cn.zhaishidan.exercise.serialization.FileSerializer._

//writeObjectToFile({x: Int => x + 1}, "/Users/stan/Projects/jvm-exercise/closure.ser")
val fun = readObjectFromFile("/Users/stan/Projects/jvm-exercise/closure.ser").asInstanceOf[(Int) => Int]
fun(5)