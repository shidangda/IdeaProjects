package demo02.setName;

public class MyThread extends Thread {
    public MyThread(){}  //不能省，否则默认构造函数会被覆盖
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
