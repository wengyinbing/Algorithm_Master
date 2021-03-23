package concurrent;

/**
 * @author wengyinbing
 * @data 2021/3/22 10:46
 **/
public class MyThread extends Thread{

    public  String name;
    /*
    重写run（）方法
    调用start（）启动线程
    但是只能继承一个线程类
     */
    public MyThread(String name){
        this.name = new String(name);
    }

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(name + " " +  i);
        }
    }


    public static void main(String[] args) {
        MyThread t1 = new MyThread("thread-1");
        MyThread t2 = new MyThread("thread-2");
        MyThread T3 = new MyThread("thread-3");

        t1.start();
        t2.start();
        T3.start();
    }
}
