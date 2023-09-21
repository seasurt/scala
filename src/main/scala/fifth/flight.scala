package fifth

import javafx.scene.chart.PieChart.Data
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import java.sql.DriverManager


object flight {
  def main(args: Array[String]): Unit = {
    //1、构建SparkConf
    val Conf: SparkConf = new SparkConf().setAppName("flight").setMaster("local[2]")
    //2、构建SparkContext
    val sc = new SparkContext(Conf)
    sc.setLogLevel("WARN")
    //3、读取数据文件
    val data = sc.textFile("C:\\Users\\31279\\Desktop\\实习项目\\datasets.csv")

//    getcounts(data)
    println("=" * 100)
    continent_r_ship(data)
    sc.stop()

    //某一大洲的机场的客户流量统计
    def continent_r_ship(data: RDD[String]): Unit = {
      val lines = data.map(x => {
        val line = x.split(",")
        val line2 = line(11).substring(5, 7)
        line(6) + "," + line(9) + "," + line2
      })
      val lines1 = lines.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1, false).collect()

      lines1.foreach(println(_))

//      lines1.foreach(line => {
//        val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "112500")
//        val sql = "insert into test2(x,y) values(?,?)"
//        val ps = con.prepareStatement(sql)
//        ps.setString(1, line._1)
//        ps.setInt(2, line._2)
//
//        ps.executeUpdate() //finished in 2.080 s
//        ps.close()
//        con.close()
//      })
    }

    //不同大洲的航班次数
    def getcounts(data: RDD[String]): Unit = {
      val lines = data.map(x => x.split(",")(10))
      val lines1 = lines.map((_, 1 * (0.00009)))
      val lines2 = lines1.reduceByKey(_ + _)
      val lines3 = lines2.sortBy(_._2, false)
      val lines4 = lines3.collect()

      lines4.foreach(println(_))
      //导入数据库
//      lines4.foreach(line => {
//        val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "112500")
//        val sql = "insert into getcounts (continents,num) values(?,?)"
//        val ps = con.prepareStatement(sql)
//        ps.setString(1, line._1)
//        ps.setInt(2, line._2.toInt)
//
//        ps.executeUpdate() //finished in 2.080 s
//        ps.close()
//        con.close()
//      })
    }

  }


}
