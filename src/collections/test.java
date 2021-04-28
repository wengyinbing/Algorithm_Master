package collections;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

import javax.swing.*;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * @author wengyinbing
 * @data 2021/3/15 19:18
 **/
public class test {
    /*
    ArrayList
    实现List
    序列化
    克隆
    随机访问接口
     */
    @Test
    public void t1(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al.getClass().getName());
        System.out.println(al);
        //遍历方式
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i));
        }
        for(int i:al){
            System.out.println(i);
        }
        Iterator<Integer> it = al.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        al.set(1,100);//更新
        System.out.println(al);
        System.out.println(al.contains(100));//判断有没有这个元素
        System.out.println(al.toArray());//转换成数组
        System.out.println(al.remove(1));
        System.out.println(al);
        Collection<Integer> c = new ArrayList<>();//父接口指向子类
        c.add(100);
        c.add(1);
        System.out.println(c.getClass().getName());
        System.out.println(al.addAll(c));
        System.out.println(al);
    }

    /*
    LinkedList
    实现了Queue
    Deque
    List接口
    序列化和克隆接口
     */
    @Test
    public void t2(){
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        Collection<Integer> c = new LinkedList<>();
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println(q.getClass().getName());

       //添加元素
        ll.add(10);
        ll.addFirst(80);
        ll.addLast(99);
        ll.add(11);//元素添加到末尾
        System.out.println(ll);
        ll.offer(9);
        ll.offerLast(88);
        System.out.println(ll);
        //读取
        System.out.println(ll.get(1));
        System.out.println(ll.getFirst());
        System.out.println(ll.peek());//读取第一个
        System.out.println(ll.peekLast());
        //删除元素
        System.out.println(ll.remove());
        System.out.println(ll.poll());//删除并返回第一个元素
        System.out.println(ll.remove(2));
        //逆序遍历
        Iterator<Integer> it = ll.descendingIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(ll.toArray());
        Collections.sort(ll);
        System.out.println(ll);//改变原来序列
        }

        /*
        HashSet
        实现了Set接口
        基于hashmap
        允许null，不准重复、不是线程安全的
         */
        @Test
        public void t3(){
            HashSet<String> hs = new HashSet<>();
            System.out.println(hs.getClass().getName());
            hs.add("ii");
            hs.add("oppo");
            hs.add("hello");
            System.out.println(hs);
            System.out.println(hs.contains("oppo"));//查找
            hs.add(null);
            Iterator<String> it = hs.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
            hs.remove("helo");
            hs.remove("oppo");
            System.out.println(hs);
            System.out.println(Arrays.toString(hs.toArray()));
            //System.out.println(Collections.sort(hs););
        }

     /*
        HashMap
        继承了abstractMap，实现了map，clone，serializable接口
        特点，无序，最多一条null key 线程不安全不同步
     */
     @Test
    public  void t4(){
        Map<Integer,String> m = new HashMap<>();
        m.put(1,"one");
        m.put(2,"two");
        m.put(3,"three");
        m.put(4,"four");
         System.out.println(m);
         System.out.println(m.get(3));
         m.remove(3);
         System.out.println(m);
         System.out.println(m.containsKey(2));
         System.out.println(m.containsValue(2));
         for(int i:m.keySet()){
             System.out.println(i);
         }
         for(String s:m.values()){
             System.out.println(s);
         }
         //Map.Entry<Integer,String> e = m.entrySet();
     }

     @Test
    public void t10(){
         Stack<Integer> s = new Stack<Integer>();
         s.push(1);
         s.pop();
         System.out.println(s);

     }
}
