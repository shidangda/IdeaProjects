package demo08.Synchronized;

public class RunnableImpl implements Runnable{
    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            payTicket();
        }
    }

    public static synchronized void payTicket(){
        //同步方法的锁对象即为new RunnableImpl()即为调用同步方法的对象this
        if(ticket>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
            ticket--;
        }
    }
}
