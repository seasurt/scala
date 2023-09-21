package com.ddd.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsUtil {
    private static final String HDFS_URL="hdfs://192.168.235.128:8020";
    private static FileSystem fs=null;
    public static FileSystem getFileSystem() throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        //设置副本数量
        conf.set("dfs.replication", "3");
        fs= FileSystem.get(new URI(HDFS_URL),conf,"root");
        return fs;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("开始...");
        FileSystem fs = HdfsUtil.getFileSystem();
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println(fileStatus.getPath());
        }
        System.out.println("-------------------------------------");
        //获取文件列表
        RemoteIterator<LocatedFileStatus> rit = fs.listFiles(new Path("/"),true);
        while (rit.hasNext()) { //快捷键itit
//            Object obj =  rit.next();
//            System.out.println(obj);//获取到每个文件的所有信息
            FileStatus fileStatus = (FileStatus) rit.next();
            System.out.println(fileStatus.getPath()); //只要路径
        }
        fs.closeAll();
        System.out.println("结束");
    }

    public void closeHdfs(){
        try {
            fs.closeAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
