package Serializable;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.function.Predicate;

/**
 * @author wengyinbing
 * @data 2021/3/15 21:26
 **/
public class test {
    /*
    序列化
    将java对象转换成字节序列
    保存在磁盘中，或者是在网络中传播
     */
    @Test
    public void t1()  {
        /*
        序列化过程
        创造一个ObjectOutputStream
        调用ObjectOutputStream对象的writeObject输出可序列化对象
         */
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.txt"));
            Person p = new Person("wengyinbing",23);
            oos.writeObject(p);
            //序列化要求如果成员变量不是基本数据类型，也不是String，而是一个引用类型，那么要求这个引用类型
            //可序列化对象，即实现serializable接口
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public  void readObject(){
        /*
        反序列化
        使用ObjectInputStream对象的readObject（）方法，注意类型转换
         */
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("out.txt"));
            Person p = (Person)ois.readObject();
            System.out.println(p);
            /*
            反序列化不调用构造方法，是由JVM自己生成对象
             */
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void t3(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            Person person = new Person("路飞", 20);
            Teacher t1 = new Teacher("雷利", person);
            Teacher t2 = new Teacher("红发香克斯", person);
            //依次将4个对象写入输入流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(person);
            oos.writeObject(t2);
            //将一个对象进行多次序列化，但是只会序列化一次，不会序列化多次
            System.out.println(t1==t2);//false
            System.out.println(t1.getP()==t2.getP());
            System.out.println(t2==t2);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void t4(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
            Teacher t1 = (Teacher)ois.readObject();
            Teacher t2 = (Teacher)ois.readObject();
            Person p = (Person) ois.readObject();
            Teacher t3 = (Teacher)ois.readObject();
            System.out.println(t1==t2);
            System.out.println(t2==t3);
            System.out.println(t2.getP() == t3.getP());
            System.out.println(t1.getP() == t2.getP());
            /*
            false
            true
            true
            true
             */
            /*
            对象被序列化都会有一个序列化编号保存在jvm中
            每次检查是否被序列化过，只有没被序列化的对象才会转换成字节序列
             */
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void t5(){
        /*
        java序列化算法存在的问题
        同一对象不会重复序列化，但是可变对象发生改变检测不出来？？
         */
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ps.txt"));
            Person p = new Person("weng",23);
            oos.writeObject(p);

            p.setName("yin");//对象发生变化
            oos.writeObject(p);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("ps.txt")));
            Person p1 = (Person)ois.readObject();
            Person p2 = (Person)ois.readObject();
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t6(){
        //控制不序列化的属性，保护作用以及减少传输量？？ transient关键字
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
            Person p = new Person("weng",23,156);
            System.out.println(p);
            oos.writeObject(p);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(("transient.txt")));
            Person p2 = (Person)ois.readObject();
            System.out.println(p2);
            //name: weng age: 23  height: 156
            //name: weng age: 23  height: 0
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Person implements Serializable{
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    private transient int  height;
    public Person(String name,int age){
        System.out.println("调用构造方法！");
        this.name = name;
        this.age = age;
    }
    public  Person(String name,int age,int height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString(){
        return "name: " + name +" age: " + age + "  height: " + height;
    }

    //自己定义序列化的方法指定具体操作
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(new StringBuffer(this.name).reverse());
        out.writeInt(age);
        out.writeObject(height + 100);
    }

    private void readObject(ObjectInputStream ins) throws IOException,ClassNotFoundException{
        //将读出的字符串反转恢复回来
        this.name = ((StringBuffer)ins.readObject()).reverse().toString();
        this.age = ins.readInt();
        this.height = ins.read();//操作byte看看
    }
}

class Teacher implements Serializable{
    private String name;
    private  Person p;

    public String getName() {
        return name;
    }

    public Person getP() {
        return p;
    }

    public  Teacher(String name, Person p){
        this.name = name;
        this.p = p;
    }

    @Override
    public  String toString(){
        return name + " " + p.getName() + " " + p.getAge();
    }
}
