package cn.zhaishidan.exercise.serialization

import java.io._

/**
 * Created by stan on 2017/2/20.
 */
object FileSerializer {

  def writeObjectToFile(obj: Object, file: String) = {
    val fileStream = new FileOutputStream(file)
    val oos = new ObjectOutputStream(fileStream)
    oos.writeObject(obj)
    oos.close()
  }

  def readObjectFromFile(file: String, classLoader: ClassLoader): Object = {
    val fileStream = new FileInputStream(file)
    val ois = new ObjectInputStream(fileStream) {
      override def resolveClass(desc: ObjectStreamClass): Class[_] =
        Class.forName(desc.getName, false, classLoader)
    }
    val obj = ois.readObject()
    ois.close()
    obj
  }
}
