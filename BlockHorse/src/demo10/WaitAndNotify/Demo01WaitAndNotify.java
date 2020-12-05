package demo10.WaitAndNotify;

public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        Object obj=new Object();
        //顾客线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("告知老板要的包子和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了，开吃！");
                        System.out.println("---------------------------------");
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
              while (true){
                  try {
                      Thread.sleep(5000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  synchronized (obj){
                      System.out.println("老板5秒钟之后做好了包子，告诉顾客可以吃包子了");
                      obj.notify();
                  }
              }
              }
        }.start();
    }

}
