package forth

import org.apache.spark.{SparkConf, SparkContext}

object AccumulatorTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("accumulator")
    val sc = new SparkContext(conf)
    //设置日志级别
    sc.setLogLevel("warn")
    //创建accumulator并初始化为0
    val accumulator = sc.longAccumulator
    //读取一个有10条记录的文件
    val linesRDD = sc.textFile("src/main/resources/words.txt")
    val result = linesRDD.map(line => {
      accumulator.add(1) //有一条数据就增加1
      line //最后返回s的值，最后一行为返回值
    })
    result.collect(); //触发action操作
    //通过value获取accumulator的值
    println("words lines is :" + accumulator.value) //6
    //关闭sc
    sc.stop()
  }


}
