package second

import org.apache.spark.{SparkConf, SparkContext}

object TransformationRdd {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new
        SparkConf().setAppName("TransformationRdd").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //设置日志输出级别
    sc.setLogLevel("WARN")

    //1、map
//    val rdd1 = sc.parallelize(List(5, 6, 4, 7, 3, 8, 2, 9, 1, 10))
//    //把rdd1中每一个元素乘以10
//    rdd1.map(_ * 10).collect().mkString(",").foreach(print(_))    //下划线“_”代表每一个元素
//    rdd1.map(_ * 10).collect().foreach(println)
//    val rdd2 = rdd1.map(_ * 10).collect() //简化写法
//    rdd2.foreach(println)
//    println(rdd2.mkString(" ")) //更加直观

    //2、filter
//    val rdd1 = sc.parallelize(List(5, 6, 4, 7, 3, 8, 2, 9, 1, 10))
//    //把rdd1中大于5的元素进行过滤
////    rdd1.filter(x => x > 5).collect.foreach(println)
//
//    val rdd2 = rdd1.filter(_ > 5).collect() //简化写法
//    println(rdd2.mkString(" "))
//    println(rdd1.filter(x=>x>5).collect().mkString(" ")) //写成一行也行

    //3、flatMap
//    val rdd1 = sc.parallelize(Array("a b c", "d e f", "h i j"))
//    //获取rdd1中元素的每一个字母
//    val rdd2 = rdd1.flatMap(_.split(" ")).collect()
//    println(rdd2.mkString(" "))

    //4、intersection、union
//    val rdd1 = sc.parallelize(List(5, 6, 4, 3))
//    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
//    //求交集
//    rdd1.intersection(rdd2).collect()
//    println(rdd1.intersection(rdd2).collect().mkString(" "))
//    //求并集
//    rdd1.union(rdd2).collect()
//    println(rdd1.union(rdd2).collect().mkString(" "))

    //5、distinct
//    val rdd1 = sc.parallelize(List(1, 1, 2, 3, 3, 4, 5, 6, 7))
//    //去重
////    rdd1.distinct
//    println(rdd1.distinct.sortBy(x => x, ascending = true).collect().mkString(" "))

    //6、join、groupByKey
//    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
//    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))
//    //join操作，注意join与union操作的区别,join将相同项关联合并，union只是单纯将所有项求并集
//    val rdd3 = rdd1.join(rdd2)
////    rdd3.collect
//    println(rdd3.collect.mkString(" "))
//    println("*"*60)
//    //求并集
//    val rdd4 = rdd1 union rdd2
//    println(rdd4.collect.mkString(" "))
//    println("*"*60)
//    //按照Key进行分组，在join的基础上求和
////    rdd4.groupByKey.collect
//    println(rdd4.groupByKey().collect().mkString)
//    //按k统计v（可能这个更是想要的结果）
//    println(rdd4.reduceByKey((x, y) => x + y).collect.mkString)
//    println(rdd4.reduceByKey(_+_).collect.mkString)   //上一句的简化写法

    //7、cogroup
//    val rdd1 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 3), ("kitty", 2)))
//    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("jim", 2)))
//    //分组
//    val rdd3 = rdd1.cogroup(rdd2)
////    rdd3.collect
//    println(rdd3.collect().mkString)
//    println("*"*60)
//    rdd3.foreach(println)   //简化写法
//    println("*"*60)
//    println(rdd3.keys.collect.mkString(" "))
//    println("*"*60)
//    println(rdd3.values.collect.mkString)


    //8、reduce
//    val rdd1 = sc.parallelize(List(1, 2, 3, 4, 5))
//    //reduce聚合
//    val rdd2 = rdd1.reduce(_ + _) //求和
//    val rdd3 = rdd1.reduce(_ * _) //阶乘
//    println(rdd2)
//    println(rdd3)
//    println("*"*60)
//    //字符串
//    val rdd4 = sc.parallelize(List("1", "2", "3", "4", "5"))
//    val rdd5 = rdd4.reduce(_ + _) //字符串拼接
//    println(rdd5) //结果34512
//    //这里可能会出现多个不同的结果，由于元素在不同的分区中，每一个分区都是一个独立的task线程去运行，这些task运行有先后关系。

    //9、reduceByKey、sortByKey
//    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2), ("小明", 1)))
//    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("小明", 2), ("kitty", 5)))
//    val rdd3 = rdd1.union(rdd2)
//    //按key进行聚合
//    val rdd4 = rdd3.reduceByKey(_ + _)
//    println(rdd4.collect().mkString(","))   //结果：(tom,4),(jerry,5),(小明,3),(kitty,7)
//    //按value的降序排序，仅仅为了使用sortByKey (位置交换)
//    //第一个t => (t._2, t._1) 将rdd4的结果按(kitty,7)->(7,kitty)变化，然后根据key值排序(key,value)，既是按数值排序，然后第二个t => (t._2, t._1)
//    //就是将(7,kitty)变回原来的样式
//    val rdd5 = rdd4.map(t => (t._2, t._1)).sortByKey(false).map(t => (t._2, t._1))
//    println(rdd5.collect().mkString(","))
//    //根据第二个值排序
//    val rdd6 = rdd4.sortBy(t => t._2, ascending = false) //可以获得同样的效果（更具通用性），ascending=false表示降序
//    println(rdd6.collect().mkString("_"))

    //10、repartition、coalesce
//    val rdd1 = sc.parallelize(1 to 10, 3)
//    println(rdd1.collect().mkString(","))
//    //打印rdd1的分区数
//    println(rdd1.partitions.size)
//
//    //利用repartition改变rdd1分区数
//    //减少分区
//    println(rdd1.repartition(2).partitions.size)    //repartition改变分区数,可增可减
//    //增加分区
//    println(rdd1.repartition(4).partitions.size)    //repartition改变分区数,可增可减
//
//    //利用coalesce改变rdd1分区数
//    //减少分区
//    println(rdd1.coalesce(2).partitions.size)
//    println(rdd1.coalesce(4).partitions.size) //默认情况下(默认shuffle参数=false)，增加分区不起作用
//    println(rdd1.coalesce(4,true).partitions.size)  //此时可以增加分区，强制修改shuffle

    //11、mapPartitions、mapPartitionsWithIndex
//    val rdd1 = sc.parallelize(1 to 10, 4)
//    rdd1.map(x => x * 10).collect   //map的输入函数是应用于RDD中每个元素
//    //mapPartitions的输入函数是应用于每个分区，也就是把每个分区中的数据作为整体来处理的
//    rdd1.mapPartitions(iter => iter.map(x => x * 10)).collect
//    println(rdd1.map(t => t * 10).collect().mkString(","))
//    println(rdd1.mapPartitions(t => t.map(t => t * 10)).collect().mkString("="))
//
//    //index表示分区号 可以获取得到每一个元素属于哪一个分区
//    rdd1.mapPartitionsWithIndex((index, iter) => iter.map(x => (index, x)))
//    //查看每个分区上的数据
//    val rdd2=rdd1.mapPartitionsWithIndex{   //默认是均分，取决与分区数
//      (index,data)=>{
//        val pNum = index
//        val iter=data
//        while (iter.hasNext){
//          println(pNum+":"+iter.next())
//        }
//        iter  //返回值，不需要标记return
//        //或者
//        //println(index+":"+data.mkString(","))
//        //data
//      }
//    }
//    rdd2.collect().mkString(",")
//    println("*"*60)
//
//    //对不同的分区进行不同的操作
//    val rdd3 = rdd1.mapPartitionsWithIndex {
//      (index, data) => {
//        index match { //match表示匹配，相当于switch
//          case 0 => data.map(_ * 0)
//          case 1 => data.map(t => t * 1) //麻烦的写法
//          case 2 => data.map(_ * 2)
//          case 3 => data.map(_ * 3)
////          case 4 => data.map(_ * 4)
//        }
//      }
//    }
//    println(rdd3.collect().mkString(","))

    //12、foreach、foreachPartition
    val rdd1 = sc.parallelize(List(5, 6, 4, 7, 3, 8, 2, 9, 1, 10))
    //foreach实现对rdd1里的每一个元素乘10然后打印输出
//    rdd1.foreach(x => println(x * 10))
//    println("*"*60)
//    println(rdd1.foreach(t => println(t * 10)))
//    println("*"*60)
//    println(rdd1.foreach(println(_))) //仅仅遍历的话
//    println("*"*60)
//    println(rdd1.foreach(println))

    //foreachPartition算子用于对RDD中的每一个分区进行操作
    //foreachPartition实现对rdd1里的每一个元素乘10然后打印输出
    rdd1.foreachPartition(iter => iter.foreach(x => println(x * 10)))
    println(rdd1.foreachPartition(iter => iter.foreach(t => println(t * 2))))


    sc.stop()
  }
}
