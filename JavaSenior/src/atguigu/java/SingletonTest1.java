package atguigu.java;

/*
* 单例设计模式：
* 1 采用一定的方法保证在在整个的软件系统中，对某个类只能存在一个对象实例
* 2.
*
* 3.区分饿汉式和懒汉式
*   饿汉式：  --> 例子：java.lang.Runtime类
*       坏处：处理加载时间过长
*       好处：饿汉式是线程安全的
*
*   懒汉式：
*       好处：延迟对象的创建
*       坏处：目前的写法坏处是线程不安全 -->到多线程时再修改为线程安全的
*
* 4.应用场景：
*   网站计数器、日志应用、数据库连接池、读取配置文件的类、Windows的Task Manager、Windows的
*   Recycle Bin（回收站）
*
* */

public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();

        System.out.println(bank1==bank2);
    }
}

//饿汉式
class Bank{
    //1.私有化类的构造器
    private Bank(){
    }

    //2.内部创建类的对象，此对象也必须声明为静态的
    private static Bank instance=new Bank();

    //3.提供公共的静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}