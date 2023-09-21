package second

import org.apache.spark.{SPARK_BRANCH, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object Test {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new
        SparkConf().setAppName("Test").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")
//    val rdd1=sc.parallelize(List(1,2,3,4,5))
//    val rdd2=sc.parallelize(Array("hadoop","hive","spark"))
//    val rdd3 = sc.makeRDD(Array(1, 2, 3, 4, 5))
//    val rdd4 = sc.makeRDD(List(1, 2, 3, 4))
//
//    println(rdd1.collect().mkString(","))
//    println(rdd2.collect().mkString(","))
//    println(rdd3.collect().mkString(","))
//    println(rdd4.collect().mkString(","))

    //自动推断，不用val data: RDD[String]，来指定类型
    val rdd1=sc.textFile("C:\\Users\\31279\\Desktop\\实习文件\\words.txt")
    rdd1.flatMap(x=>x.split(" ")).foreach(println(_))

    val rdd2 = rdd1.flatMap(_.split(" "))
    val rdd3 = rdd2.map((_, 1))   //等价于val rdd3 = rdd2.map(x=>(x, 1))
    rdd3.reduceByKey(_+_).foreach(println(_))

    sc.stop()



  }
}
