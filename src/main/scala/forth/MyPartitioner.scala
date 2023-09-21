package forth

import org.apache.spark.Partitioner

//自定义分区，分别重写numPartitions方法和getPartition方法
class MyPartitioner(num:Int) extends Partitioner{
  //指定rdd的总的分区数,重写numPartitions方法
  override def numPartitions: Int = {
    num
  }
  //消息按照key的某种规则进入到指定的分区号中
  override def getPartition(key: Any): Int ={
    //这里的key就是单词，单词长度为4放到0分区，5放到1分区，6放到2分区，其他全部放到0分区
    val length: Int = key.toString.length
    length match {
      case 4 =>0
      case 5 =>1
      case 6 =>2
      case _ =>0
    }
  }
}
