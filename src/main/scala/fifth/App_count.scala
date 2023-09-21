package fifth

import org.apache.spark.{SparkConf, SparkContext}

object App_count {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("App_count").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("warn")
    val data = sc.textFile("C:\\Users\\31279\\Desktop\\案例一.txt")
    val lines = data.map(x => x.split(",")(3))  //将文件中的“，”删除，并取出第四列数据
//    lines.foreach(println(_))
    val lines2 = lines.map((_, 1))  //将十个第4列数据与1组成一对键值对（key，value）,方便下面计算每个app的浏览次数
//    lines2.foreach(println(_))
    val lines3 = lines2.reduceByKey(_ + _) //4,1,2,3 ，将拥有相同键key的计算合并
//    lines3.foreach(println(_))
    val lines4 = lines3.sortBy(_._2, false)
//    lines4.foreach(println(_))
    val lines5 = lines4.collect()
    lines5.foreach(println(_))
    println("=" * 50)
    data.map(x => x.split(",")(3)).map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._2, false).collect().foreach(println(_))

    sc.stop()
  }


}
