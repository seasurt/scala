package second

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object TopN {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new
        SparkConf().setAppName("TopN").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")
    val data = sc.textFile("src/main/resources/access.log")
    //4、切分每一行，过滤出丢失的字段数据，获取页面地址
    val filterRDD = data.filter(x => x.split(" ").length > 10) //过滤脏数据
//    filterRDD.foreach(println(_))
    val urlAndOne: RDD[(String, Int)] = filterRDD.map(x => x.split(" ")(10)).map((_, 1)) ////获取网址
    //5、相同url出现的1累加
    val result: RDD[(String, Int)] = urlAndOne.reduceByKey(_ + _)
    //6、按照次数降序
    val sortedRDD: RDD[(String, Int)] = result.sortBy(_._2, false)
    //7、取出url出现次数最多的前5位
    val top5: Array[(String, Int)] = sortedRDD.take(5)
    top5.foreach(println)


    sc.stop()
  }

}
