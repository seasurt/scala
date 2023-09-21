package third

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object StorageLevelDemo {
  def main(args: Array[String]): Unit = {
    //1、构建SparkConf
    val sparkConf: SparkConf = new SparkConf().setAppName("StorageLevelDemo").setMaster("local[2]")
    //2、构建SparkContext
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("warn")
    sc.setCheckpointDir("hdfs://maimaster:8020/checkpoint")
    val rdd1 = sc.textFile("/words.txt")
    rdd1.checkpoint
    val rdd2 = rdd1.flatMap(_.split(" "))
    val rdd3 = rdd2.cache
    rdd3.collect
    val rdd4 = rdd3.map((_, 1))
    val rdd5 = rdd4.persist(StorageLevel.MEMORY_ONLY) //StorageLevel.MEMORY_ONLY 缓存级别
    rdd5.collect.foreach(println(_))

  }

}
