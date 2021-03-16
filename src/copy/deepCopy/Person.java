package copy.deepCopy;


import java.io.Serializable;

/**
 * @author wengyinbing
 * @data 2021/3/16 15:02
 **/
public class Person implements  Cloneable, Serializable {
    /*
    深拷贝
    为拷贝的对象当中的每一个可达对象都创建内存空间进行存储
    其中使用Object当中的clone要求为每一个可达引用对象都是实现cloneable接口。实现clone方法
     */

    private  String name;//属于引用数据类型，但是String对象是存在常量池当中，这个数据是不可以更改的，
    // 看起来好像更改了，其实是创建了一新对象，改变了引用的指向
    private int height;//基本数据类型
    private Age age;//引用数据类型

    public Person(String name, int height, Age age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
    //copy构造器
    public Person(Person p){
        this.name = p.name;
        this.age = p.age;
        this.height = p.height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", age=" + age +
                '}';
    }

    //通过clone函数实现拷贝  实现cloneable接口
    @Override
    public Object clone()  {
        Object obj= null;
        try{
            obj = super.clone();}
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        Person p = (Person)obj;
        p.age = (Age)p.getAge().clone();
        return obj;
    }
}
