

class BaoZi{
    String pi;
    String xian;
    boolean flag=false;
}

class BaoZiPu extends Thread{
    BaoZi bz;

    public BaoZiPu(BaoZi bz){
        this.bz=bz;
    }
    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag==true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bz.pi="薄皮";
                bz.xian="三鲜";
                bz.flag=true;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(bz.pi+bz.xian+"包子做好了，请享用吧！");
                bz.notify();
            }
        }
    }
}

class ChiHuo extends Thread{
    BaoZi bz;
    public ChiHuo(BaoZi bz){  //设置了新的构造方法，默认的构造方法必须显示定义，否则不能调用，增强了程序的安全性（bz必须赋值）
        this.bz=bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag==false){
                    try {
                        System.out.println("老板,给"+Thread.currentThread().getName()+"来个包子！");
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bz.flag=false;
                System.out.println(Thread.currentThread().getName()+"正在吃"+bz.pi+bz.xian+"包子！");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"吃完了"+bz.pi+bz.xian+"包子！");
                bz.notify();
            }
        }
    }
}

public class Excercise {
    public static void main(String[] args) {
        BaoZi bz=new BaoZi();
        new ChiHuo(bz).start();
        new BaoZiPu(bz).start();
    }

}
