package second

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object UV {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new
        SparkConf().setAppName("UV").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")

    val data: RDD[String] = sc.textFile("src/main/resources/access.log")
    //统计uv
    //切分每一行，获取第一个元素 也就是ip
    val ips = data.map(x => x.split(" ")(0))  //获取IP地址
    //按照ip去重
    val distinctIP = ips.distinct()

    val uv = distinctIP.count()
    println("PV:" + uv) //1050
    sc.stop()
  }

}
