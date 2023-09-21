package fifth

import fifth.mobilDemo.{closeSc, getData}
import io.netty.handler.codec.smtp.SmtpRequests.data
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object mobilDemo {
    //定义一个全局变量
    var sc: SparkContext = _   //下划线：自动初始化

//    app统计
    def main(args: Array[String]): Unit = {
//        val conf = new SparkConf().setMaster("local[2]").setAppName("mobilDemo")
//        val sc = new SparkContext(conf)
//        //设置日志级别
//        sc.setLogLevel("warn")

//        val data = sc.textFile("src/main/resources/案例一.txt")
//        val lines=data.map(x=>x.split(",")(3))
//        //        lines.foreach(println(_))
//        val lines2=lines.map((_, 1))
//        val lines3=lines2.reduceByKey(_ + _) //4,1,2,3
//        val lines4=lines3.sortBy(_._2, false)
//        val lines5=lines4.collect()
//        lines5.foreach(println(_))
//
//
//        //一行代码，连缀写法，不建议
//        //        sc.textFile("src/main/resources/案例一.txt").map(x=>x.split(",")(3)).map((_, 1)).reduceByKey(_ + _).sortBy(_._2, false).collect().foreach(println(_))
//        sc.stop()

//        //app统计
//        appCount
//        //日活
//        getDau()
//        //月活
//        getMau
        //流量统计
        getUp_downFlow()


    }

    def getSparkConf={
        val conf = new SparkConf().setMaster("local[2]").setAppName("mobilDemo")
        sc = new SparkContext(conf)
        //设置日志级别
        sc.setLogLevel("warn")
        sc
    }

    def getData:RDD[Array[String]]={
        val sc=getSparkConf
//        val lines = sc.textFile("src/main/resources/案例一.txt")map(x=>x.split(",")  //相对路径不行
        val lines=sc.textFile("C:\\Users\\31279\\Desktop\\案例一.txt").map(x=>x.split(",")) //绝对路径
        lines
    }

    def closeSc: Unit ={
        sc.stop()
    }

    //app统计
    def appCount={
        val lines=getData
        lines.filter(x=>x.length==7 && x(3)!=null)
            .map(x=>(x(3).trim,1))  //trim:去掉左右空格
            .reduceByKey(_+_)
            .sortBy(_._2,false) //将访问次数降序排序
            .collect()
            .foreach(x=>{
                println(x._1+"这款APP访问的次数是："+x._2)
            })
        closeSc

    }


    //日活
    def getDau()={
        val lines=getData
        lines.filter(x=>x.length==7 && x(4)!=null)
            .map(x=>(x(4).trim,1))  //trim:去掉左右空格
            .reduceByKey(_+_)
            .sortBy(_._2,true) //将访问次数降序排序
            .collect()
            .foreach(println(_))
        closeSc
    }

    //月活

    def getMau:Unit={ //编号+时间共同决定
        val lines=getData
        lines.filter(x=>x.length==7 && x(2)!=null && x(4)!=null)
            .map(x=>{
                val imei=x(2).trim
                val time=x(4).trim
                //把时间截取到月份
                val month=time.substring(0,time.lastIndexOf("-"))
                imei+":"+month
            }).distinct() //数据去重
            .map(x=>{
                val month=x.split(":")(1).trim
                (month,1)
            }).reduceByKey(_+_)
            .foreach(x=>{
                println(x._1+"活跃用户数量："+x._2)
            })
    }

    //流量统计
    def getUp_downFlow(){
        val lines = getData
        lines.filter(x => x.length == 7 && x(3) != null && x(5) != null && x(6) != null)
            .map(x => {
                val app = x(3).trim //APP
                val up = x(5).trim.toInt //上行流量，注意转换成Int
                val down = x(6).trim.toInt //下行流量，转换成Int
                (app, (up, down))
            }).reduceByKey((x, y) => {
            /**
             * x._1+y._1将相近的两个上行流量相加
             * x._2+y._2将相近的两个下行流量相加
             */
            (x._1 + y._1, x._2 + y._2)
        }).foreach(x => {
            println(x._1 + "这款应用的上下行流量总和分别是：")
            println("上行流量总和：" + x._2._1)
            println("下行流量总和：" + x._2._2)
        })
    }





}
