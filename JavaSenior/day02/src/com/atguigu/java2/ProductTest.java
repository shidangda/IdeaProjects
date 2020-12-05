package com.atguigu.java2;

/*
* 线程通信应用：生产者消费者问题
*
* 分析：
* 1.是否是多线程问题？是，生成者线程，消费者线程
* 2.是否有共享数据？是，店员（或产品）
* 3.如何解决线程的安全问题？同步机制，有三种方法
* 4.是否涉及线程的通信？是
* */

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Producer p1=new Producer(clerk);
        p1.setName("生产者1");

        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");

        Consumer c2=new Consumer(clerk);
        c2.setName("消费者2");


        p1.start();
        c1.start();
        c2.start();
    }
}

class Clerk{
    private int productCount=0;

    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品...");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品...");

        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

