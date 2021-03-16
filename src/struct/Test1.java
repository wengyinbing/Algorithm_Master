package struct;

import org.junit.Test;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/3/15 14:42
 **/
public class Test1 {
    @Test
    public void test1(){
        /*
        vector
         */
        //构造方法
        Vector<Integer> v1 = new Vector<Integer>(10);//不写的话默认大小是10
        System.out.println(v1.capacity());
        System.out.println(v1.size());
        Vector<Integer> v2 = new Vector<>(10,2);
        //Vector(Collection c) //包含集合C元素的向量
        v1.add(10);
        v1.add(1,12);
        System.out.println(v1.toString());
        System.out.println(v1.capacity());
        v1.addElement(1);

        System.out.println(v1.size());
        System.out.println(v1.firstElement());
        //v1.clear();//清空
        v1.set(0,9);
        System.out.println(v1.subList(0,2));
        Object[] o = v1.toArray();
        //System.out.println(v1.toArray()[1]);
        System.out.println(o[1]);
        System.out.println(v1.getClass().getName());
        System.out.println(v1.elements());
        while(!v1.isEmpty()){
            v1.remove(0);
        }
        System.out.println(v1.toString());
    }

    @Test
    public void t2(){
        /*
        Satack()
         */
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.search(1));
        s.clear();
        System.out.println(s.capacity());
        System.out.println(s.size());
    }

    @Test
    public void t3(){
        /*
        HashTable
         */
        Hashtable<Integer,String> ht = new Hashtable<>();
        System.out.println(ht.getClass().getName());
        ht.put(3,"opppo");
        ht.put(1,"lili");
        System.out.println(ht.toString());
        System.out.println(ht.get(1));
        //System.out.println(ht.elements());
        Enumeration e = ht.elements();//枚举
        while(e.hasMoreElements()){//遍历value
            System.out.println(e.nextElement());//没有了会报错
        }
        Enumeration e1 = ht.keys();
        while(e1.hasMoreElements()){
            System.out.println(e1.nextElement());
        }
        ht.put(1,"haha");//相当更新了
        System.out.println(ht.toString());
        System.out.println(ht.size());
    }
}
