package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {

//    println("hello spark")
    //1、构建sparkConf对象 设置application名称和master地址 --本地的maven引用就是本地的spark环境
    val conf: SparkConf = new
        SparkConf().setAppName("WordCount").setMaster("local[2]")
    //2、构建sparkContext对象,该对象非常重要，它是所有spark程序的执行入口
    // 它内部会构建 DAGScheduler和 TaskScheduler 对象
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")
    //3、读取数据文件
    val data: RDD[String] = sc.textFile("C:\\Users\\31279\\Desktop\\实习文件\\words.txt")
    //4、 切分每一行，获取所有单词
    val words: RDD[String] = data.flatMap(x => x.split(" "))
    //5、每个单词计为1
    val wordAndOne: RDD[(String, Int)] = words.map(x => (x, 1))
    //6、相同单词出现的1累加
    val result: RDD[(String, Int)] = wordAndOne.reduceByKey((x, y) => x + y)
    //按照单词出现的次数降序排列 第二个参数默认是true表示升序，设置为false表示降序
    val sortedRDD: RDD[(String, Int)] = result.sortBy(x => x._2, false)
    //7、收集数据打印
    val finalResult: Array[(String, Int)] = sortedRDD.collect()
    finalResult.foreach(println)
    //8、关闭sc
    sc.stop()

  }
}
