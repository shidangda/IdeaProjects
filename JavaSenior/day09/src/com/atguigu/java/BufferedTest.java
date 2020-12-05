package com.atguigu.java;

/*
* 处理流之一：缓冲流的使用
*
* 1.缓冲流：
* BufferedInputStream
* BufferedOutputStream
* BufferedReader
* BufferedWriter
*
* 2.作用：提供流的读取、写入速度
*     提高读写速度的原因：内部提供了一个缓冲区
*
* 3.处理流，就是“套接”在已有的流的基础之上
*
* */


import org.junit.Test;

import java.io.*;

public class BufferedTest {
    @Test
    public void testBufferedReaderBufferedWriter(){
        //使用带资源的try-catch语句块实现文本文件复制
        try(BufferedReader br=new BufferedReader(new FileReader(new File("日记.txt")));
            BufferedWriter  bw=new BufferedWriter(new FileWriter(new File("日记1.txt")))){
//            char[] cbuf=new char[1024];
//            int len;
//            while ((len=br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//                bw.flush();
//            }
            //方式二：使用String每次读取一行
            String data;
            while((data=br.readLine()) !=null){
                bw.write(data+"\n");  //data中不包含换行符
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }





}
