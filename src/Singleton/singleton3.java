package Singleton;

/**
 * @author wengyinbing
 * @data 2021/1/30 9:39
 **/
public class singleton3 {
    /*
    懒汉模式
    使用volatile关键字修饰实例
    可以初始化完全
    volatile 可以保证共享变量可见性，并且禁止指令重排优化
    A a = new A()
    声明一个引用
    创建一个实例
    将引用指向实例
     */
    private static volatile singleton3 singleton = null;

    public static singleton3 getInstance() {
        //先检查实例是否存在，存在才进入下面的同步快
        if (singleton == null) {
            //同步快，线程安全建立实例
            synchronized (singleton3.class) {
                if (singleton == null) {
                    //在检查一遍是否实例为null
                    singleton = new singleton3();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(singleton3.getInstance().hashCode());
        System.out.println(singleton3.getInstance().hashCode());
    }
}
