package demo09.Lock;

public class Demo01Ticket {
    public static void main(String[] args) {
        Runnable run=new RunnableImpl();

        Thread t0=new Thread(run);  //t0,t1,t2使用的是同一个Runnable对象，故使用的是同一个锁和ticket资源
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);

        t0.start();
        t1.start();
        t2.start();
    }
}
