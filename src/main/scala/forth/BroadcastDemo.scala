package forth

import org.apache.spark.{SparkConf, SparkContext}

object BroadcastDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("BroadcastDemo").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("warn")
    val rdd1 = sc.textFile("src/main/resources/words.txt")
    val word = "spark"
    //没有使用广播
//    val rdd2 = rdd1.flatMap(_.split(" ")).filter(x => x.equals(word))
//    rdd2.foreach(x => println(x))

    //通过调用sparkContext对象的broadcast方法把数据广播出去
    val broadCast = sc.broadcast(word)
    //在executor中通过调用广播变量的value属性获取广播变量的值
    val rdd2 = rdd1.flatMap(_.split(" ")).filter(x => x.equals(broadCast.value))
    rdd2.foreach(x => println(x))
  }

}
