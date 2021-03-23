package concurrent;

/**
 * @author wengyinbing
 * @data 2021/3/22 10:54
 **/
public class MyRunnable implements  Runnable {
    /*
    实现runnable接口
    重写run（）方法
    创建MyRunnable实例，用这个实例作为target创建Thread对象，该对象才是真正的线程对象
    调用start（）方法，启动线程
     */
    public  static int count = 20;
    @Override
    public void  run() {
        System.out.println(Thread.currentThread().getName() + " is running");
        while(count>0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " count: " + count--);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        Thread t1 = new Thread(myRunnable,"THREAD-10");

        t1.start();
        t.start();
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
