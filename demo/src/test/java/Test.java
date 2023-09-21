import com.ddd.utils.HdfsUtil;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Test {
    private static HdfsUtil hdfsUtil =null;

    //在所有方法执行之前执行，并且只执行一次，用来初始化配置文件等等
    @Before
    public void init(){
        System.out.println("init...");
        hdfsUtil=new HdfsUtil();
    }

    //真正执行的代码
    @org.junit.Test
    public void getAllFilesOrDirc() throws Exception {
        System.out.println("真正的执行代码");
        FileSystem fs = hdfsUtil.getFileSystem();
        //写死的目标路径，项目中应该传过来，做项目时也不应该查询根目录
        String target="/demo";
        FileStatus[] fileStatuses = fs.listStatus(new Path(target));
        for (FileStatus fileStatus : fileStatuses) {  //foreach
            System.out.println(fileStatus.getPath());
        }
        Assert.assertNotEquals(null,fileStatuses);  //断言
    }

    // 上传文件夹
    @org.junit.Test
    public void addDir() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        String target="/hadoopDemo"; //写死的目标路径，项目中应该传过来

        boolean exists = fs.exists(new Path(target)); //判断是否存在指定路径,可以少一次与 hadoop 的交互
        System.out.println(exists);
        if(!exists) {
            boolean flag = fs.mkdirs(new Path(target));//没有就创建，有就不创建
            Assert.assertEquals(true,flag);
        }else{
            System.out.println("没有创建");
        }

//        String target="/hadoopDemo2/demo"; //创建多级路径
//        boolean flag = fs.mkdirs(new Path(target));// 返回 true，说明可以创建多级文件夹
//        System.out.println(flag);
    }
    // 上传文件
    @org.junit.Test
    public void addFile() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        //本地文件位置（window中）
        Path src=new Path("C:\\Users\\31279\\Desktop\\2.jpg");
        Path target=new Path("/hadoopDemo/"); //hadoop 上的位置
        //此方法没有返回值，可以测试引起变化的内容,hadoop 的路径不存在会自动创建，但不会执行上传操作
        //通过此方法创建的文件夹，再次执行上传操作也不会成功，所以不建议使用
        fs.copyFromLocalFile(src,target); //同名会覆盖
        Path test=new Path("/hadoopDemo/2.jpg");
        boolean exists = fs.exists(test);
        String result=exists?"存在":"不存在";
        System.out.println(result);
        Assert.assertEquals(true,exists);
    }
    //删除
    @org.junit.Test
    public void deleteDir() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        Path target=new Path("/hadoopDemo/2.jpg");
        //为 true 时，当参数为目录时，会递归删除此目录下的所有文件，谨慎操作
        //参数为具体的文件路径时会只删除目录下的指定文件
        boolean flag = fs.delete(target, true);
        Assert.assertEquals(true,flag);
    }

    //修改
    @org.junit.Test
    public void modify() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
//        Path src=new Path("/hadoopDemo/2.jpg");
//        Path target=new Path("/hadoopDemo/3.jpg");
//         Path src=new Path("/demo/aaa");
//         Path target=new Path("/demo/aaa2");
        Path src=new Path("/hadoopDemo2");
        Path target=new Path("/hadoopDemo3");
        boolean flag = fs.rename(src,target);
        Assert.assertEquals(true,flag);
    }

    //下载
    @org.junit.Test
    public void download() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        Path src=new Path("/hadoopDemo/3.jpg");
        boolean flag = fs.exists(src);
        if(flag){
            Path target=new Path("C:/Users/31279/Desktop");
//             fs.copyToLocalFile(src,target);//此方法无返回值,可以用
            // 第一个参数为 true 时，下载完成时会删除服务器的路径，推荐使用（false）
//             fs.copyToLocalFile(true,src,target);

//            fs.copyToLocalFile(false,new Path("/hadoopDemo/3.jpg"),target);
            //路径为目录时，会递归将此目录下的所有文件都下载下来
            fs.copyToLocalFile(false,new Path("/demo"),target);
        }
        boolean flag2 = fs.exists(src);
        Assert.assertEquals(true,flag2);
    }

    // 创建文件并写入内容
    @org.junit.Test
    public void createFile() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        String target="/hadoopDemo/test.txt";
        Path path = new Path(target);
        // 第二个参数为是否覆盖，参数为 false 时，如果文件已经存在将会报错
        FSDataOutputStream os = fs.create(path, true);
        String content="你好啊,hadoop";
        // os.writeChars(content);//中文会乱码
        // os.writeUTF(content); //方式 1
        byte[] b = content.getBytes();
        os.write(b,0,b.length);//方式 2
        os.close();
    }

    //获取文件内容
    @org.junit.Test
    public void readFileContent() throws Exception{
        FileSystem fs = hdfsUtil.getFileSystem();
        Path path = new Path("/hadoopDemo/test.txt");
        FSDataInputStream is = fs.open(path);   //获取对象输出流
        //方式 1,自定义缓冲区
         byte[] b = new byte[16];//缓冲区设置太大，会有很多乱码似的占位符
         int len=0;
         while((len=is.read(b))!=-1){
             String s = new String(b);
             System.out.println(s);
         }
        //方式 2
//        InputStream ws = is.getWrappedStream();//通过文件系统的数据流获取一个包装流
//        BufferedReader br = new BufferedReader(new InputStreamReader(ws));
//        String s = br.readLine();
//        System.out.println(s);
//        br.close();
//        ws.close();
        is.close();
    }

    //合并文件：hadoop 适合做离线文件处理，本身也不提倡对文件内容进行修改
    @org.junit.Test
    public void mergeFiles() throws Exception{ //不支持往文件中添加内容
        FileSystem fs = hdfsUtil.getFileSystem();
        Path path = new Path("/hadoopDemo/test.txt");
        FileStatus[] fileStatuses = fs.listStatus(path);
        System.out.println(fileStatuses[0].getLen());//16
        FSDataInputStream is = fs.open(path);
        FSDataOutputStream os = fs.append(path);
        IOUtils.copyBytes(is,os,16);
    }



    //在所有方法执行之后执行，并且只执行一次，用来进行资源回收

    public void destroy(){
        System.out.println("destroy...");
        hdfsUtil.closeHdfs();
    }

}
