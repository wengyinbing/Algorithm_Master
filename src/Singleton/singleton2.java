package Singleton;

/**
 * @author wengyinbing
 * @data 2021/1/30 9:28
 **/
public class singleton2 {
    /*
    懒汉模式
    枷锁了
    但是sychronize独占排他锁，并发性能差，创建成功之后，获得实例还是串行化操作
     */
    private static singleton2 singleron = null;

    //私有化构造方法，好在内部控制创建实例的数目？？单例模式不是就一个实例吗
    private singleton2() {

    }


    //获得唯一实例方法
    public static synchronized singleton2 getInstance() {//上锁 独占排他锁
        if (singleron == null) {
            singleron = new singleton2();
        }
        return singleron;
    }

    //其他的操作
    public void singletonOperation() {

    }

    //其他属性
    private String singletonData;//必须通过实例在通过接口调用

    public String getSingletonData() {
        return singletonData;
    }


    public static void main(String[] args) {
        System.out.println(singleton2.getInstance().hashCode());
        System.out.println(singleton2.getInstance().hashCode());
        System.out.println(singleton2.getInstance().getSingletonData());//string 成员变量会被初始化，被初始化为null，但是局部变量不会被初始化
    }
}

