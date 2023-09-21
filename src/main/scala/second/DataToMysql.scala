package second

import org.apache.spark.{SparkConf, SparkContext}

import java.sql.DriverManager

object DataToMysql {
  def main(args: Array[String]): Unit = {
    //1、构建SparkConf
    val sparkConf: SparkConf = new SparkConf()
      .setAppName("DataToMysql").setMaster("local[2]")
    //2、构建SparkContext
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("warn")
    //3、读取数据文件
    val data = sc.textFile("src/main/resources/person.txt")
    //4、切分每一行 // id name age
    val person = data.map(x => x.split(",")).map(x => (x(0), x(1), x(2).toInt))
//    person.foreach(println(_))


     person.foreach(line=>{
       val con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spark", "root", "132586")
       val sql = "insert into person (userid,username,age) values(?,?,?)"
       val ps = con.prepareStatement(sql)
       ps.setInt(1, line._1.toInt)
       ps.setString(2, line._2)
       ps.setInt(3, line._3)
       ps.executeUpdate() //finished in 2.080 s
       ps.close()
       con.close()
     })


    sc.stop()

  }

}
