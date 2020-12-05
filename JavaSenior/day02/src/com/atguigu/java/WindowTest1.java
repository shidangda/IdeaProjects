package com.atguigu.java;

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

/*方式一：使用同步代码块解决实现Runnable接口来创建线程的线程安全问题：可以使用this充当同步监视器
* 1 操作共享数据的代码即为需要被同步的代码 --> synchronized不能包含少了，也不能包含代码多了
* 2 共享数据：多个线程共同操作的变量，比如:ticket就是共享数据
* 3 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁。要求：多个线程必须要共用同一把锁
*   补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器
*
*
* */

class Window1 implements Runnable{
    private int ticket=100;
    Object obj=new Object();  //放在run方法之前，保证多个线程共用同一把锁

    @Override
    public void run() {
        while (true) {
            synchronized (this){//synchronized (obj) {
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