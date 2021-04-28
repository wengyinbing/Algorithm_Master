package 笔试.wanmeishijie.t4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/27 20:40
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x,y;
        LinkedList<box> ll = new LinkedList<>();
        LinkedList<box1> ll1 = new LinkedList<>();
        for(int i=0;i<n;i++){
            x = s.nextInt();
            y = s.nextInt();
            ll.add(new box(x,y));
            ll1.add(new box1(x,y));
        }
        Collections.sort(ll);
        x = ll.getFirst().x;
        y = ll.getFirst().y;
        ll.remove(0);
        int result = 1;
        for(box b:ll){
            if(b.x < x && b.y < y){
                result += 1;
                x = b.x;
                y = b.y;
            }
        }
        Collections.sort(ll1);
        x = ll1.getFirst().x;
        y = ll1.getFirst().y;
        ll1.remove(0);
        int result1 = 1;
        for(box1 b:ll1){
            if(b.x < x && b.y < y){
                result1 += 1;
                x = b.x;
                y = b.y;
            }
        }if(result >= result1){
        System.out.println(result);}
        else{
            System.out.println(result1);
        }
    }
}
class box implements  Comparable<box>{
    public int x;
    public int y;

    public box(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "box{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(box o) {
        if(x==o.x &&y==o.y){
        return 0;}
        else if(x==o.x&&y > o.y){
            return -1;
        }
        else if(x==o.x&&y < o.y){
            return 1;
        }
        else if(x>o.x){
            return -1;
        }
        return 1;
    }
}

class box1 implements  Comparable<box1>{
    public int x;
    public int y;

    public box1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "box1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(box1 o) {
        if(x==o.x &&y==o.y){
            return 0;}
        else if(y==o.y&&x > o.x){
            return -1;
        }
        else if(y==o.y&&x < o.x){
            return 1;
        }
        else if(y>o.y){
            return -1;
        }
        return 1;
    }
}
//class compare1 implements
