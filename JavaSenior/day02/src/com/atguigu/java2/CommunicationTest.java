package com.atguigu.java2;

/*
  线程通信
* 涉及到三个方法：
* wait():一旦执行此方法，当前线程就进入Waiting状态，并释放同步监视器
* notify():一旦执行此方法，就会唤醒被wait的一个线程
* notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
*
* 说明：
* 1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中
  2.线程通信三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常
  3.wait(),notify(),notifyAll()定义在java.lang.Object类中

  面试题：sleep()和wait()的异同？
  1.不同点：
    1）两个方法声明的位置不一样，Thread类声明静态的sleep()，Object类中声明wait()
    2）调用要求不一样：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块或同步方法中
    3）如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
* */

public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();

        Thread t1=new Thread(number);
        Thread t2=new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int number=1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();

                if(number<100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        //使得调用如下wait()方法的线程进入Waiting状态（锁被释放）
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else break;
            }
        }
    }
}

