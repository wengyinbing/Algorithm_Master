package Singleton;

/**
 * @author wengyinbing
 * @data 2021/1/30 9:55
 **/
public class Singleton {
    /*
    使用类的静态内部类
    可以是实现线程安全并且不会导致启动变慢？
    调用才会装载，实现了延迟加载
     */
    private static class SingletonHolder {

        //静态初始化器，由JVM来保证线程安全
        private static Singleton singleton = new Singleton();
    }

    private Singleton() {
        System.out.println("构造方法！");
    }

    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
        String s = "12";
        System.out.println((int) (s.charAt(1) - '0'));
    }
}
