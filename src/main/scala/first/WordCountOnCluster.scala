package first

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountOnCluster {

  def main(args: Array[String]): Unit = {
    //1、构建sparkConf对象 设置application名称
    val sparkConf: SparkConf = new SparkConf().setAppName("WordCountOnSpark")
    //2、构建sparkContext对象,该对象非常重要，它是所有Spark程序的执行入口 打成jar包提交到集群中运行 运行结果 ：
    // 它内部会构建 DAGScheduler和 TaskScheduler 对象
    val sc = new SparkContext(sparkConf)
    //设置日志输出级别
    sc.setLogLevel("WARN")
    //3、读取数据文件 /datas/words.txt 文件路径在命令行运行jar包时指定
    val data: RDD[String] = sc.textFile(args(0))
    //4、 切分每一行，获取所有单词
    val words: RDD[String] = data.flatMap(x => x.split(" "))
    //5、每个单词计为1
    val wordAndOne: RDD[(String, Int)] = words.map(x => (x, 1))
    //6、相同单词出现的1累加
    val result: RDD[(String, Int)] = wordAndOne.reduceByKey((x, y) => x + y)
    //7、把计算结果保存在hdfs上
    result.saveAsTextFile(args(1))
    //8、关闭sc
    sc.stop()

  }

}
