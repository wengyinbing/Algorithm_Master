package Singleton;

/**
 * @author wengyinbing
 * @data 2021/1/30 9:48
 **/
public class singleton4 {
    /*
    饿汉模式
    加载类的时候就创建实例
    优点：天生线程安全，调用快，使用是没有延迟
    缺点：启动慢，有可能造成资源浪费
     */
    private static singleton4 singleton = new singleton4();

    private singleton4() {
        //私有化构造方法，控制实例化数目
        System.out.println("创建实例");
    }

    public static singleton4 getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(singleton4.getInstance().hashCode());
        System.out.println(singleton4.getInstance().hashCode());
    }
}
