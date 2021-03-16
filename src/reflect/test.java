package reflect;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/3/16 8:15
 **/
public class test {
    @Test
    public void t1(){
        String name = "wengyinbing";
        //System.out.println(name.getClass());
        Class c1 = name.getClass();
        System.out.println(c1.getClass());
        //Type 可以得到基本类型的类型
        System.out.println(Integer.TYPE);
        //获取类的构造方法
        Test1 t = new Test1();
        Class c2 = t.getClass();

        //getDeclaredConstructors 返回类的构造器数组（全部构造器 包括类型为private）
        //getConstructors 只返回public的构造器
        Constructor[] constructors = c2.getDeclaredConstructors();//c2.getConstructors();
        System.out.println(Arrays.toString(constructors));
        for(Constructor c:constructors){
            System.out.print("构造器访问修饰符"+ Modifier.toString(c.getModifiers())  + c.getModifiers()+ " 参数 ");
            Class[] p =  c.getParameterTypes();
            for(Class cc:p){
                System.out.print(" " + cc.getName());
            }
            System.out.println(" ");
        }
        //根据参数类型获取构造方法 因为可能再找不到对应构造方法会报错
        try{
            Constructor constructors1 = c2.getDeclaredConstructor();
            System.out.println(Modifier.toString(constructors1.getModifiers()));

            Class[] c5 = {int.class,String.class};//参数类型列表
            Constructor constructor2 = c2.getDeclaredConstructor(c5);
            System.out.print(Modifier.toString(constructor2.getModifiers()) + " 参数 ：");
            for(Class cc : constructor2.getParameterTypes()){
                System.out.print(cc.getName() + " ");
            }
            System.out.println();
            //!!!!!!!调用构造方法 远程方法调用
            constructor2.newInstance(24,"wengyinbing");//对象实例化

            //调用类的私有构造方法 SetAccessible
            Class[] p1 = {String.class};
            constructor2 = c2.getDeclaredConstructor(p1);
            constructor2.setAccessible(true);//调用private方法
            constructor2.newInstance("wengyinbing");
        }
        catch(Exception e){
           e.printStackTrace();
        }

    }

    @Test
    public void t2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //调用方法
        //Method invoke 两个参数一个是类的实例 一个是方法需要的参数列表
        Test1 t1 = new Test1();
        Class c = t1.getClass();
        //构造函数参数列表
        Class[] p = {int.class,String.class};
        //构造器
        Constructor constructor = c.getDeclaredConstructor(p);//可能找不会报错
        System.out.println(constructor);
        //实例化一个Test1的对象
        constructor.setAccessible(true);//访问私有化构造器
        //System.out.println(constructor.newInstance(24,"wengyinbing").getClass());
        Test1 t2 = (Test1)constructor.newInstance(24,"wengyinbing");//要强制类型装换一下，不然编译错误
        //调用方法的参数列表
        Class[] p1 = {String.class};
        //Method
        Method m = c.getDeclaredMethod("welcome",p1);
        m.setAccessible(true);// 访问私有化方法
        //invoke
        //调用方法
        //Method invoke 两个参数一个是类的实例 一个是方法需要的参数列表
        m.invoke(t2,"tiantiankaixin1");

    }
}



class Test1{
    private int age;
    private String name;
    private int testint;
    public Test1(){}
    public Test1(int age){
        this.age = age;
    }
     Test1(int age,String name){
        this.age = age;
        this.name = name;
         System.out.println("name: " + name +" age: "+ age);
    }
    private Test1(String name){
        this.name = name;
        System.out.println("My name is " + name);
    }


    private void welcome(String tips){
        System.out.println("调用方法: welome()");
        System.out.println(this.name);
        System.out.println(tips);
    }
}