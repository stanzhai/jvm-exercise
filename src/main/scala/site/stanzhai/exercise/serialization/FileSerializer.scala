package site.stanzhai.exercise.serialization

import java.io._

object FileSerializer {

  def writeObject(obj: Object, file: String) = {
    val fileStream = new FileOutputStream(file)
    val oos = new ObjectOutputStream(fileStream)
    oos.writeObject(obj)
    oos.close()
  }

  def readObject(file: String): Object = {
    val fileStream = new FileInputStream(file)
    val ois = new ObjectInputStream(fileStream)
    val obj = ois.readObject()
    ois.close()
    obj
  }

  def readObjectWithClassLoader(file: String, classLoader: ClassLoader): Object = {
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
