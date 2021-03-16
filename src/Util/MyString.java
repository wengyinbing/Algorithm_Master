package Util;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/3/14 9:45
 **/
public class MyString {
   @Test
    public void t1(){
        //格式化
        int d = 1;
        float f = 0.33f;
        //string创建内存空间
        String s1 = "oppo";//常量池
        String s2 = "oppo";
        String s3 = new String("oppo");//堆
        String s4 = s1;
        System.out.println(s1==s2);
        System.out.println(s1==s4);
        System.out.println(s3==s1);

        System.out.printf("%d,%f,%s\n",d,f,s1);
        String s5 = String.format("%d,%f,%s\n",d,f,s1);
        System.out.println(s5);
    }

    @Test
    public void t2(){
       String s1 = "hello";
       String s2 = "wengyinbing";
       System.out.println(s1.charAt(1));//返回index的char
        System.out.println(s1.compareTo(s2));
        char[] s = {'1','g'};
        //char与string的转换
        s2 = String.copyValueOf(s,1,1);
        s1.getChars(0,1,s,0);
        char[] c = s1.toCharArray();
        System.out.println(c);
        System.out.println(s);
        System.out.println(s2);
        System.out.println(s1.endsWith("llo"));
        System.out.println(s1.intern());//字符串的规范化表示
        System.out.println(s1.indexOf("he"));
        System.out.println(s1.matches("h2.?"));
        System.out.println(s1.split("l"));//String[]
        //trim() 忽略前后个空格
        System.out.println(s1.substring(2,4));//子串
    }

    @Test
    public void t3(){
       //StringBuffer 线程安全的可变对象 StringBuilder线程不安全的可变对象 直接在对象上进行操作
        StringBuffer sb = new StringBuffer(10);
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.append("Hello,wengyinbing!");
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(sb.length());
        sb.reverse();
        System.out.println(sb);
        sb.insert(0,"oopp");
        System.out.println(sb);
        System.out.println(sb.replace(0,1,"huahua")==sb);
    }
    public static void main(String[] args) {
        MyString s = new MyString();
        s.t1();
    }
}
