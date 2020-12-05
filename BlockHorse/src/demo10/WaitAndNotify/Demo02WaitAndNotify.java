package demo10.WaitAndNotify;

public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        Object obj=new Object();
        //顾客1线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("顾客1告知老板要的包子和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了，顾客1开吃！");
                        System.out.println("---------------------------------");
                    }
                }
            }
        }.start();

        //顾客2线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (obj){
                        System.out.println("顾客2告知老板要的包子和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("包子已经做好了，顾客2开吃！");
                        System.out.println("---------------------------------");
                    }
                }
            }
        }.start();

        //包子铺线程
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
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}
