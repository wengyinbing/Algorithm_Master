package Singleton;

/**
 * @author wengyinbing
 * @data 2021/1/30 8:34
 **/
public class singleton1 {
    /*
    懒汉模式
    非线程安全
    用的时候才实例化，启动快，占用资源小，无锁
     */
    private static singleton1 singleton = null;

    public static singleton1 getInstance() {
        if (singleton == null) {
            singleton = new singleton1();
            System.out.println("创建实例！");
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(singleton1.getInstance().hashCode());
        System.out.println(singleton1.getInstance().hashCode());
    }

}
