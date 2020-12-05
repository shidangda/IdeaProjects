package com.atguigu.java;

/* 使用同步代码块来解决继承Thread类来创建线程的线程安全问题：需将共享数据声明为静态的，同步监视器也声明为静态的
 * 在继承Thread类创建多线程的方式中，可以考虑使用当前类对应的Class对象充当同步监视器
 *
 * */

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1=new Window2();
        Window2 t2=new Window2();
        Window2 t3=new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}



class Window2 extends Thread{
    private static int ticket=100;
    static Object obj=new Object();  //放在run方法之前，保证多个线程共用同一把锁

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {  //由于是使用继承Thread类的方式创建线程对象，故此处的不能用this,而是用Window2.class
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);  //使用alt+enter可以自动用try/catch块处理异常
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出车票，tick号为：" + ticket--);
                } else break;
            }
        }
    }
}