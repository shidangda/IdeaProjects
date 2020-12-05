package atguigu.java;

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }
    }
}







public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1=new MyThread1();
//        MyThread2 m2=new MyThread2();
//
//        m1.start();
//        m2.start();

        //创建Thread类的匿名内部类的方式
        new Thread(){  //匿名内部类实现接口，括号里面的构造器参数为空
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==1){
                        System.out.println(Thread.currentThread().getName()+" : "+i);
                    }
                }
            }
        }.start();
    }

}
