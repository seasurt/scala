package second

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.sql.{Connection, DriverManager, PreparedStatement}

object DataToMysqlByPartition {
  def main(args: Array[String]): Unit = {
    //1、构建SparkConf
    val sparkConf: SparkConf = new SparkConf().setAppName("DataToMysqlByPartition").setMaster("local[2]")
    //2、构建SparkContext
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("warn")
    //3、读取数据文件
    val data: RDD[String] = sc.textFile("src/main/resources/person.txt")
    // print(data.collect().mkString("==="))
    //4、切分每一行 // id name age
    val personRDD: RDD[(String, String, Int)] = data.map(x => x.split(",")).map(x => (x(0), x(1), x(2).toInt))
    //5、把数据保存到mysql表中
    //使用foreachPartition每个分区建立一次链接，减少与mysql链接次数--更加合理，推荐时间使用
    personRDD.foreachPartition(iter => {
      //把数据插入到mysql表操作
      //1、获取连接
      val connection: Connection =
      DriverManager.getConnection("jdbc:mysql://localhost:3306/spark", "root", "132586")
      //2、定义插入数据的sql语句
      val sql = "insert into person(userid,username,age) values(?,?,?)"
      //3、获取PreParedStatement
      val ps: PreparedStatement = connection.prepareStatement(sql)
      try {
//        val ps: PreparedStatement = connection.prepareStatement(sql)
        //4、获取数据,给？号 赋值
        iter.foreach(line => {
          ps.setString(1, line._1)
          ps.setString(2, line._2)
          ps.setInt(3, line._3)
          //设置批量提交
          ps.addBatch()
        })
        //执行批量提交
        ps.executeBatch()
      } catch {
          case e: Exception => e.printStackTrace()
      } finally {
        if (ps != null) {
          ps.close()
        }
          if (connection != null) {
              connection.close()
        }
      }
    })
    sc.stop()


  }

}
