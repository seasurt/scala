package fifth

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.sql.DriverManager
import scala.util.Random


object Accumulator3 {
  def main(args: Array[String]): Unit = {
    //1、构建SparkConf
    val Conf: SparkConf = new SparkConf().setAppName("Accumulator3").setMaster("local[2]")
    //2、构建SparkContext
    val sc = new SparkContext(Conf)
    sc.setLogLevel("WARN")
    //3、读取数据文件
    //val data = sc.textFile("hdfs:///db/AirlineDataset.csv")
    val data = sc.textFile("C:\\Users\\31279\\Desktop\\AirlineDataset.csv")
   // getcounts(data)
    continent_r_ship(data)
    sc.stop()

    //某一大洲的机场的客户流量统计

    //各大洲机场数量比例
    def continent_r_ship(data: RDD[String]): Unit = {
      var lines = data.map(x => {
        val line = x.split(",")

        line(9) + " " + line(6)
      })
      /*var ssss= Random.nextInt(100000)*/
      var lines1 = lines.distinct().map(x => (x.substring(0, 3), 1)).reduceByKey(_ + _).sortBy(_._1, false).collect()

      lines1.foreach(println(_))

      lines1.foreach(line => {
        val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
        val sql = "insert into airline3(country,num) values(?,?)"
        val ps = con.prepareStatement(sql)
        ps.setString(1, line._1)
        ps.setInt(2, line._2)

        ps.executeUpdate() //finished in 2.080 s
        ps.close()
        con.close()
      })
    }
    /*def continent_r_ship(data: RDD[String]): Unit = {
      var lines = data.map(x => {
        val line = x.split(",")
        val line2 = line(11).substring(5, 7)
        line(6)+ "abcd" + line(9)+ "abcd" + line2
      })

      var lines1=lines.map(x => (x,Random.nextInt(70000))).reduceByKey(_ + _).sortBy(_._1,false).collect()

      lines1.foreach(println(_))

      lines1.foreach(line => {
        val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
        val sql = "insert into airline(airport, country, month, num) values(?,?,?,?)"
        val ps = con.prepareStatement(sql)
        val airport_name = line._1.split("abcd")(0)
        val contry = line._1.split("abcd")(1)
        val date = line._1.split("abcd")(2)
        ps.setString(1, airport_name)
        ps.setString(2, contry)
        if (date.contains("/")) {
          ps.setString(3, date.substring(0, 1))
        }
        else {
          ps.setString(3, date)
        }
        ps.setInt(4,line._2)

        ps.executeUpdate() //finished in 2.080 s
        ps.close()
        con.close()
      })
    }*/

    //不同大洲的航班次数
    def getcounts(data: RDD[String]): Unit = {
      val lines = data.map(x => x.split(",")(10))
      val lines1 = lines.map((_, 1))
      val lines2 = lines1.reduceByKey(_+_)
      val lines3=lines2.sortBy(_._2, false)
      val lines4 = lines3.collect()

      lines4.foreach(println(_))
      //导入数据库
      lines4.foreach(line => {
        val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
        val sql = "insert into getcounts (continents,num) values(?,?)"
        val ps = con.prepareStatement(sql)
        ps.setString(1, line._1)
        ps.setInt(2, line._2.toInt)

        ps.executeUpdate() //finished in 2.080 s
        ps.close()
        con.close()
      })
    }

  }


}