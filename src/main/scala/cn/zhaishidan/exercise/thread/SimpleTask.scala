package cn.zhaishidan.exercise.thread

import java.util.concurrent.Callable

/**
  * Created by stan on 2016/12/1.
  */
class SimpleTask extends Callable[Int] {

  override def call(): Int = {
    val span = 5
    println(s"I'll need $span seconds to do this task!")
    Thread.sleep(span * 1000)
    span
  }
}
