package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object AssignmentHero {
//  case class Person(classID:Int,name:String,age:Int, sex:String,keMu:String, score:Int)
  def main(args: Array[String]): Unit = {
    //1、构建sparkConf对象 设置application名称和master地址 --本地的maven引用就是本地的spark环境
    val conf: SparkConf = new
        SparkConf().setAppName("AssignmentHero").setMaster("local[2]")
    //2、构建sparkContext对象,该对象非常重要，它是所有spark程序的执行入口
    // 它内部会构建 DAGScheduler和 TaskScheduler 对象
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")
    val rdd1: RDD[Array[String]] = sc.textFile("src/main/resources/heros.txt").map(_.split(" "))
    val rdd2 = rdd1.map(x => (x(0),x(1),x(2),x(3),x(4),x(5)))
    val rdd3: Long = rdd2.groupBy(_._2).count()
    //1.一共有多少个小于20岁的人参加考试？
    val rdd4 = rdd2.filter(_._3.toInt < 20).groupBy(_._2).count()
    println(rdd4)
    //2.一共有多少个等于20岁的人参加考试？
    val rdd5 = rdd2.filter(_._3.toInt == 20).groupBy(_._2).count()
    println(rdd5)
    //3.一共有多少个大于20岁的人参加考试？
    val rdd6 = rdd2.filter(_._3.toInt > 20).groupBy(_._2).count()
    println(rdd6)
    sc.stop()

  }

}
