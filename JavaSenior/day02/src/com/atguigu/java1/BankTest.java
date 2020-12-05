package com.atguigu.java1;

public class BankTest {
}

class Bank{

    private Bank(){}

    private static Bank instance=null;

    public static Bank getInstance(){
        //方式二 高效的懒汉式:将同步代码块放在if语句里面
        if (instance==null) {
            synchronized (Bank.class) {
                if(instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
        //方式一 低效的懒汉式
//        synchronized (Bank.class){
//            if(instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
    }
}