package copy.shallowCopy;

/**
 * @author wengyinbing
 * @data 2021/3/16 14:41
 **/
public class Person implements Cloneable{
    /*
    java数据分为基本数据类型 和 引用数据类型
    基本数据类型使用值传递 引用数据类型使用 引用传递，引用传递表示将一个对象的存储地址传递过去
    浅拷贝时 使用引用传递 导致拷贝对象和被拷贝对象指向一个地址空间的对象
    一旦一方对这个对象进行更改，另一方也可以看见
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
        catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
}
