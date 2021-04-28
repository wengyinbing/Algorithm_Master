package compareTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author wengyinbing
 * @data 2021/4/4 18:34
 **/
public class compare1 implements Comparable<compare1>{

    //double area;
    double width;
    double height;

    public compare1(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(compare1 o) {
        //return this.height > o.height;
        if(height == o.height){
            return 0;
        }
        else if(height > o.height){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "compare1{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    public static void main(String[] args) {
        List<compare1> list = new ArrayList<>();
        Random random = new Random();
        list.add(new compare1(random.nextDouble(),random.nextDouble()));
        list.add(new compare1(random.nextDouble(),random.nextDouble()));
        list.add(new compare1(random.nextDouble(),random.nextDouble()));
        list.add(new compare1(random.nextDouble(),random.nextDouble()));
        list.add(new compare1(random.nextDouble(),random.nextDouble()));
        for(compare1 c :list){
            System.out.println(c);
        }
        System.out.println("---------------- -----使用comparable的compareTo方法--------------------------");
        Collections.sort(list);
        for(compare1 c : list){
            System.out.println(c);
        }
        System.out.println("----------------------使用comparator的compare方法-------------------------");
        Collections.sort(list,new comparator());
        for(compare1 c: list){
            System.out.println(c);
        }
    }
}
