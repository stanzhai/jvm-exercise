package cn.zhaishidan.exercise.serialization

import java.io.{ByteArrayOutputStream, FileInputStream}

/**
  * Created by stan on 2017/3/12.
  */
class FileClassLoader() extends ClassLoader {

  override def findClass(name: String): Class[_] = {
    val file = name.split('.').last + ".class"
    val in = new FileInputStream(file)
    val bos = new ByteArrayOutputStream
    val bytes = new Array[Byte](4096)
    var done = false
    while (!done) {
      val num = in.read(bytes)
      if (num >= 0) {
        bos.write(bytes, 0, num)
      } else {
        done = true
      }
    }
    val data = bos.toByteArray
    defineClass(name, data, 0, data.length)
  }
}
