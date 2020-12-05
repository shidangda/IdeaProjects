package com.atguigu.java;

/*
* 使用同步方法解决继承Thread类来创建线程的线程安全问题：需要将同步方法声明为静态的,同步监视器为所属类的Class对象
*
*
* 关于同步方法总结：
* 1 同步方法仍然设计到同步监视器，只是不需要我们显示声明。
* 2 非静态的同步方法，同步监视器是：this，即调用非静态同步方法的当前类的对象
*   静态的同步方法，同步监视器是同步方法所属类的Class对象
*
*
* */





public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public static synchronized void show() {
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
