package fifth

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Dau_Mau {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Dau_Mau").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("warn")
    val data = sc.textFile("C:\\Users\\31279\\Desktop\\案例一.txt")
//    getDau(data)
    println("*********月活*********")
    getMau(data)
    sc.stop()
  }

  def getDau(data: RDD[String]): Unit = {
    val lines = data.map(x => x.split(",")(4))
//    lines.foreach(println(_))
    val lines2 = lines.map(x => (x, 1))
//    lines2.foreach(println(_))
    val lines3 = lines2.reduceByKey(_ + _)
//    lines3.foreach(println(_))
    val lines4 = lines3.sortBy(_._1, true)
    lines4.collect().foreach(println(_))
//    println("*" * 50)
//    data.map(x => x.split(",")(4)).map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect().foreach(println(_))
  }

  def getMau(data: RDD[String]): Unit = { //编号+时间共同决定
    val df=data.map(x => {
      val line = x.split(",")
      line(4) + ":" + line(5)
    })
    df.foreach(println(_))
    println("="*60)
    val df2=df.distinct() //去重
    df2.foreach(println(_))
//    println("="*60)
//    val df3=df2.map(x => x.split("-")(1))
//    df3.foreach(println(_))
//    println("="*60)
//    val df4=df3.map(x=>(x,1)).reduceByKey(_ + _).sortBy(_._1).collect()
//    df4.foreach(println(_))

//      .distinct().map(x => x.split("-")(1)).map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect().foreach(println(_))
  }


}
