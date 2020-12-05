package com.atguigu.java2;

/*
* 创建线程的方式四：使用线程池
*
* 面试题：创建多线程有几种方式？四种！
* */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1=(ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);
//        System.out.println(service.getClass());

        //2.执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());  //适合于使用Runnable
        service.execute(new NumberThread1());  //适合于使用Runnable
//        service.submit(new NumberThread());  //适合于使用Callable
        //3.关闭连接池
        service.shutdown();
    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}