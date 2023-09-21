package fifth

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import java.io.FileNotFoundException
import java.sql.DriverManager
import scala.io.{BufferedSource, Source}


object Airline {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Airline").setMaster("local[2]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("WARN")
    val data = sc.textFile("hdfs:///db/AirlineDataset.csv")

    //调用方法
    //    Passager_age(data)
    //    println("=" * 50)
    //    North_america(data)
    //    println("=" * 50)
    //    Europe(data)
    //    println("=" * 50)
    //    Asia(data)
    //    println("=" * 50)
    //    Africa(data)
    //    println("=" * 50)
    //    Oceania(data)
    //    println("=" * 50)
    //    South_america(data)
    Airport(data)
    sc.stop()

  }


  //1、乘客的年龄分布
  def Passager_age(data: RDD[String]): Unit = {
    val lines = data.map(x => x.split(",")(4))
    //    lines.foreach(println(_))
    val lines2 = lines.map((_, 1))
    val lines3 = lines2.reduceByKey(_ + _)
    val lines4 = lines3.sortBy(_._2, false)
    val lines5 = lines4.collect()
    lines5.foreach(println(_))

    //导入数据库
    lines5.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into age (age,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setInt(1, line._1.toInt)
      ps.setInt(2, line._2.toInt)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })

  }

  //2、客运量前五的机场
  def Airport(data: RDD[String]): Unit = {
    val a1 = data.map(x => x.split(",")(6))
    //    lines.foreach(println(_))
    val a2 = a1.map((_, 1))
    val a3 = a2.reduceByKey(_ + _)
    val a4 = a3.sortBy(_._2, false).take(100)
    //      val a5 = a4.collect()
    a4.foreach(println(_))

    a4.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into airport (Airport_name,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }


  //3、各大州机场的航班延误率
  def North_america(data: RDD[String]): Unit = {
    //1、北美的航班状况：1234
    def start(s: String): Boolean = {
      s.contains("North America")
    }

    val df = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val df2 = df.filter(start)
    val df3 = df2.map(x => x.split(":")(1))
    val df4 = df3.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("北美的航班状况:")
    df4.foreach(println(_))

    df4.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into north_america (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      //        ps.setInt(1, line._1.toInt)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }

  def Europe(data: RDD[String]): Unit = {
    //2、欧洲的航班情况：abcd
    def start2(s: String): Boolean = {
      s.contains("Europe")
    }

    val dfa = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val dfb = dfa.filter(start2)
    val dfc = dfb.map(x => x.split(":")(1))
    val dfd = dfc.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("欧洲的航班状况:")
    dfd.foreach(println(_))

    dfd.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into europe (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }

  def Asia(data: RDD[String]): Unit = {
    //3、亚洲的航班情况：ABCD
    def start3(s: String): Boolean = {
      s.contains("Asia")
    }

    val dfA = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val dfB = dfA.filter(start3)
    val dfC = dfB.map(x => x.split(":")(1))
    val dfD = dfC.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("亚洲的航班状况:")
    dfD.foreach(println(_))

    dfD.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into asia (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }

  def Africa(data: RDD[String]): Unit = {
    //4、非洲的航班情况：_A_B_C_D
    def start4(s: String): Boolean = {
      s.contains("Africa")
    }

    val df_A = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val df_B = df_A.filter(start4)
    val df_C = df_B.map(x => x.split(":")(1))
    val df_D = df_C.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("非洲的航班状况:")
    df_D.foreach(println(_))

    df_D.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into africa (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }

  def Oceania(data: RDD[String]): Unit = {
    //5、大洋洲的航班情况：_a_b_c_d
    def start5(s: String): Boolean = {
      s.contains("Oceania")
    }

    val df_a = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val df_b = df_a.filter(start5)
    val df_c = df_b.map(x => x.split(":")(1))
    val df_d = df_c.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("大洋的航班状况:")
    df_d.foreach(println(_))

    df_d.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into oceania (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }

  def South_america(data: RDD[String]): Unit = {
    //6、南美洲的航班情况：xyzu
    def start6(s: String): Boolean = {
      s.contains("South America")
    }

    val dfx = data.map(x => {
      val line = x.split(",")
      line(10) + ":" + line(14)
    })
    val dfy = dfx.filter(start6)
    val dfz = dfy.map(x => x.split(":")(1))
    val dfu = dfz.map(x => (x, 1)).reduceByKey(_ + _).sortBy(_._1).collect()
    println("南美洲的航班状况:")
    dfu.foreach(println(_))

    dfu.foreach(line => {
      val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "132586")
      val sql = "insert into south_america (status,count) values(?,?)"
      val ps = con.prepareStatement(sql)
      ps.setString(1, line._1.toString)
      ps.setInt(2, line._2)
      ps.executeUpdate() //finished in 2.080 s
      ps.close()
      con.close()
    })
  }




}
