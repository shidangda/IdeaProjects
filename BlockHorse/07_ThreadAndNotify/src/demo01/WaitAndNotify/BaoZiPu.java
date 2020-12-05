package demo01.WaitAndNotify;

public class BaoZiPu extends Thread{
    private BaoZi bz;

    public BaoZiPu(BaoZi bz){
        this.bz=bz;
    }

    @Override
    public void run() {  //生产包子的方法
        int count=0;
        while (true){
            synchronized (bz){
                if(bz.flag==true){
                    try {
                        bz.wait();  //Thread.sleep(long)方法没有释放锁，而Object.wait释放了锁，使得其他线程可以使用同步线程块或方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(count%2==0){
                    bz.pi="薄皮";
                    bz.xian="三鲜";
                }
                else {
                    bz.pi="冰皮";
                    bz.xian="牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生产："+bz.pi+bz.xian+"包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                bz.flag=true;
                System.out.println("包子铺已经生产好了："+bz.pi+bz.xian+"包子，吃货可以开始吃了");
                bz.notify();
            }
        }
    }
}
