package demo09.Lock;

import java.util.concurrent.locks.*;

//public class RunnableImpl implements Runnable{
//    private int ticket=100;
//    Lock l=new ReentrantLock();
//
//    @Override
//    public void run() {
//        while (true){
//            l.lock();
//
//            if(ticket>0){
//                try {
//                    Thread.sleep(10);
//                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
//                    ticket--;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
//                    l.unlock();
//                }
//            }
//        }
//    }
//}

public class RunnableImpl implements Runnable{
    int ticket=100;  //由于t0,t1,t2都用的是同一个Runnable实例，故此处不加static问题也不大
    Lock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            if(ticket>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
                System.out.println(Thread.currentThread().getName()+"-->"+"正在卖第"+ ticket +"张票");
            }
            lock.unlock();
        }
    }
}


