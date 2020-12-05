package atguigu.java;

/*
* 多线程的创建，方式一：继承与Thread类
* 1. 创建一个继承于Thread类的子类
* 2. 重写Thread类的run()方法  -->将此线程执行的操作声明在run()方法中
* 3. 创建Thread类的子类的对象
* 4. 通过此对象调用start()方法
*
*
* */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
