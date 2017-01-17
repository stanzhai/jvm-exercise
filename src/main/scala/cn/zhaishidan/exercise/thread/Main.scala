package cn.zhaishidan.exercise.thread

import java.util.concurrent.Executors

/**
  * Created by stan on 2016/11/15.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val service = Executors.newCachedThreadPool()
    service.shutdown()
    println("test")
  }

}
