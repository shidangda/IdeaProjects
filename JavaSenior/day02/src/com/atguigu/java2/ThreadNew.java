package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*创建线程的方式三：实现Callable接口
*
* 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
* 1.call()方法可以有返回值
* 2.call()可以抛出异常，被外面的操作捕获，获取异常信息
* 3.Callable可以支持泛型
*
*
* */


public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread=new NumThread();
        //4.将此Callable接口实现类的对象传递到FutureTask构造器，创建FutureTask的对象（因为FutureTask实现了Runnable接口和Future接口）
        FutureTask<Integer> futureTask=new FutureTask<>(numThread);
        Integer sum= null;
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象并调用start()
        new Thread(futureTask).start();
        try {
            sum = futureTask.get();  //获取Future构造器参数Callable实现类重写的call()方法的返回值
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1.创建一个实现Callable的实现类
class NumThread implements Callable<Integer>{
    //2.实现call()方法，将此线程需要执行的操作声明在call()方法中
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}