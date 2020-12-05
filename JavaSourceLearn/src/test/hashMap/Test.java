package test.hashMap;

import java.util.*;

public class Test {
    //此时在Project Structure里面修改了sourcepath的路径，将原来的C:\Program Files\Java\jdk-12.0.2\lib\src.zip源码路径改为了解压后的C:\Program Files\Java\jdk-12.0.2\lib\src路径
    //使得可以修改jdk源码或者添加注释，通过调试单步进入相应的类里面
    public static void main(String[] args) {
        Map<String,Double> hashMap=new HashMap<>();

        hashMap.put("K1",0.1);
        hashMap.put("K2",0.2);
        hashMap.put("K3",0.3);
        hashMap.put("K4",0.4);
    }
}
