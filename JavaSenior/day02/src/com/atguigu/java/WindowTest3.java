package com.atguigu.java;

/*
* 使用同步方法解决实现Runnable接口来创建线程的线程安全问题：同步方法的监视器为this
* */


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    private int ticket = 100;
    Object obj = new Object();  //放在run方法之前，保证多个线程共用同一把锁

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {  //同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);  //使用alt+enter可以自动用try/catch块处理异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + ticket--);
        }
    }
}
