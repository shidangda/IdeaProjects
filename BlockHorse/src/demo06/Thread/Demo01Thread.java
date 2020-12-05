package demo06.Thread;

public class Demo01Thread {
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        mt.start();  //多线程
//        mt.run();  //单线程
        for(int i=0;i<20;i++){
            System.out.println("run:"+i);
        }
    }

}
