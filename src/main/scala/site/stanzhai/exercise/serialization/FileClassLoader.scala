package site.stanzhai.exercise.serialization

import java.io.{ByteArrayOutputStream, FileInputStream}

/**
  * A Simple File Class Loader
  * The file name is the SimpleClassName (without package name)
  */
class FileClassLoader() extends ClassLoader {

  override def findClass(fullClassName: String): Class[_] = {
    val file = fullClassName.split('.').last + ".class"
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
    defineClass(fullClassName, data, 0, data.length)
  }
}
