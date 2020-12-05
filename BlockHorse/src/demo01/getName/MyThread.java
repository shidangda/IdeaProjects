package demo01.getName;

public class MyThread extends Thread {
    @Override
    public void run() {
//        String name=getName();
//        System.out.println(name);
//        Thread t=Thread.currentThread();
//        System.out.println(t);
//
//        String name=t.getName();
//        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
    }
}
