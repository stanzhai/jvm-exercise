package cn.zhaishidan.exercise.serialization

import java.io.{File, FileOutputStream}
import java.net.URLClassLoader

/**
  * Created by stan on 2017/3/12.
  */
object ClassManipulator {

  def saveClassFile(obj: AnyRef): Unit = {
    val classLoader = obj.getClass.getClassLoader
    val className = obj.getClass.getName
    val file = className.replace('.', '/') + ".class"
    val stream = classLoader.getResourceAsStream(file)

    val fileStream = new FileOutputStream(file)
    var data = stream.read()
    while (data != -1) {
      fileStream.write(data)
      data = stream.read()
    }
    fileStream.flush()
    fileStream.close()
  }

}
