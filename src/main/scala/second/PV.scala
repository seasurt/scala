package second

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object PV {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new
        SparkConf().setAppName("PV").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")

    val data: RDD[String] = sc.textFile("src/main/resources/access.log")
    //4、统计pv
    val pv: Long = data.count()
    println("PV:" + pv) //14619

    sc.stop()
  }

}
