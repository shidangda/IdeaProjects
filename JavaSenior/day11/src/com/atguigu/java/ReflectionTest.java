package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1(){
        Person p1=new Person("Tom",12);
        p1.age=10;
        System.out.println(p1.toString());

        p1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz=Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p=(Person) obj;
        System.out.println(obj.toString());

        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person)cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");

        //疑问：直接new对象或反射的方式都可以调用公共的结构，开发用哪个？
        //建议：直接new的方式
        //什么时候会用反射？ 反射的特征：动态性 （服务器运行时根据客户机请求来构造不同类的对象)
        //疑问：反射机制与面向对象中的封装性是不是矛盾的？
        //不矛盾。

        /*
        1.类的加载过程：
        程序经过javac.exe命令后，会生成一个或多个字节码文件接着我们使用java.exe命令对某个字节码文件进行
        解释运行。相当于将某个字节码文件加载到内存中。此过程就成为类的加载。加载到内存中的类，我们就成为运行
        时类，就作为Class的一个实例。

        2.换句话说，Class的实例就对应一个运行时类。（不能new Class的实例)
        3.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们可以通过不同的方式来获取此运行时类
        //上面三种需要掌握






        */
    }

    @Test
    public void test3() throws ClassNotFoundException {
        //方式一 调用运行时类的属性: .class
        //注：方式一在编译时就把所要反射的类固定了，没有很好体现动态性，因为只有运行时才知道要构建哪些类的对象
        Class clazz1=Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        //注：由于我们需要用反射来创建运行时类的对象，可是方法二已经有运行时类的对象了，就没有必要用反射了。
        //比如说运行服务器要根据客户机发来的请求(login或者register)来创建一个运行时类的对象，显然这时
        //我们内存中没有相应的对象，故需要用反射来根据获取的请求来创建相应的对象。也就是方式三用的比较多
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);
        //方式三: 调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器：ClassLoader （了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);
    }

    //Class实例可以是哪些结构的说明
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
