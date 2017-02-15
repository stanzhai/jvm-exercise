package cn.zhaishidan.exercise.thread

<<<<<<< HEAD
import java.util.concurrent.Executors
=======
import java.util.concurrent.{Executors, TimeUnit}

import scala.concurrent.TimeoutException
>>>>>>> 16f9969e34827e465624b6fe52fc485877e2c8d9

/**
  * Created by stan on 2016/11/15.
  */
object Main {

  private def doTask(): Unit = {
    val service = Executors.newFixedThreadPool(1)
    val task = new SimpleTask()
    // task并不是马上执行
    val future = service.submit(task)
    try {
      // 开始执行等待结果返回
      val result = future.get(1, TimeUnit.SECONDS)
      // 会报超时异常，但是这个task依然在运行
    } catch {
      case e: TimeoutException =>
        println(s"exception: $e")
        // 由于ThreadPool只有1个线程，上面的task还没执行完，
        // 所以，这次从get得等上个task结束才能得到执行，所以超时等待时间超过了5s，否则这个线程也会超时
        val result = service.submit(task).get(11, TimeUnit.SECONDS)
        println(s"the task result is $result")
    } finally {
      service.shutdown()
    }
  }

  def main(args: Array[String]): Unit = {
<<<<<<< HEAD
    val service = Executors.newCachedThreadPool()
    service.shutdown()
    println("test")
=======
    doTask()
    println("press any key to exit!")
    System.in.read()
>>>>>>> 16f9969e34827e465624b6fe52fc485877e2c8d9
  }

}
