package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author wengyinbing
 * @data 2021/3/22 11:03
 **/
public class MyCallable implements Callable {
    /*
    创建实现Callable接口的类myCallable
    以myCallable为参数创建FutureTask对象
    将FutureTask作为参数创建Thread对象
    调用线程对象的start()方法

    有返回值
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is running!");
        return 1;
    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread t1 = new Thread(futureTask);
         t1.start();

        try {
            Thread.sleep(1000);
            System.out.println("获得myrunnable的返回值："+ futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is running!");
    }
}
