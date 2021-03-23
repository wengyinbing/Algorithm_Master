package Util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wengyinbing
 * @data 2021/3/17 15:35
 **/
public class HashEquals {
    /*
    重写equals
    和hashcode函数
     */
    int age;
    String name;
    public HashEquals(){}
    public HashEquals(String name,int age){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HashEquals{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    //

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if(this == o){//先判断引用指向是不是一致
            return true;
        }
        if(o == null){
            return false;//规定，如果null就false
        }
        HashEquals that = (HashEquals) o;
        if(that.age == age && name.equals(that.name)){
            return true;
        }
        return false;
    }

    public boolean equalsString(String that){
        if(that.isEmpty() && name.isEmpty()){
            return true;
        }
        if(!name.isEmpty()){
            return name.equals(that);
        }
        return false;
    }
    @Override
    public int hashCode() {
        System.out.println(this);
       // System.out.println(Objects.hash(age, name));
        //return super.hashcode()
        return Objects.hash(age, name);
    }

    public void change(HashEquals he){
        he.name = "oppo";
        he.age = 10000;
    }

    public static void main(String[] args) {
        HashEquals he1 = new HashEquals("weng",10);
        HashEquals he2 = new HashEquals("yin",18);
        HashEquals he3 = new HashEquals("weng",10);
        System.out.println(he1 == he2);
        System.out.println(he1.equals(he2));
        System.out.println(he1 == he3);
        System.out.println(he1.equals(he3));
       // System.out.println(he1.hashCode());
        //System.out.println(he2.hashCode());
        //System.out.println(he3.hashCode());
        Set<HashEquals> set = new HashSet<>();
        set.add(he1);
        set.add(he3);//没有重写hashset的时候用的父类，计算出的he1 与 he3
        //的哈希值不相等
        //那么就会放入hashset当中
        System.out.println(set);
        //hashset插入的时候计算hashcode，如果不一样加入，但是如果一样的话，就需要检查equals，减少了equals的次数

        he1.change(he2);
        System.out.println(he2);
    }
}
