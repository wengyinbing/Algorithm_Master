package 笔试.zhongxing.T4;

import jdk.jshell.SourceCodeAnalysis;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/4/24 15:04
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1, n2, q;
        n1 = s.nextInt();
        n2 = s.nextInt();
        q = s.nextInt();
        int sum = n1 + n2;
        boolean[] q12 = new boolean[sum+1];
        int[] index = new int[sum+1];
        for(int i=1;i<=n1;i++){
            q12[i] = true;
            index[i] = 0;
        }
        for(int i=n1+1;i<=n1+n2;i++){
            q12[i] = false;
            index[i] = 0;
        }
        int temp ;
        for(int i=0;i<q;i++){
            temp = s.nextInt();
            q12[temp] =!q12[temp];
            index[temp]=i+1;
        }
        int a=0,b=0;
        for(int i=1;i<=sum;i++){
            if(q12[i]){
                a++;
            }
        }
        b = sum - a;
        ArrayList<stua> l1 = new ArrayList<>();
        ArrayList<stua> l2 = new ArrayList<>();
        for(int i=1;i<=sum;i++){
            if(q12[i]){
                l1.add(new stua(i,index[i]));
            }
            else{
                l2.add(new stua(i,index[i]));
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i=0;i<l1.size();i++){
            System.out.print(l1.get(i).val);
            if(i==l1.size()-1){
                System.out.println();
            }
            else{
                System.out.print(" ");
            }
        }
        for(int i=0;i<l2.size();i++){
            System.out.print(l2.get(i).val);
            if(i==l2.size()-1){
                System.out.println();
            }
            else{
                System.out.print(" ");
            }
        }
    }
}
class stua implements Comparable<stua>{
    public int val;
    public int index;

    public stua(int val, int index) {
        this.val = val;
        this.index = index;
    }

    @Override
    public int compareTo(stua o) {
        if(val==o.val && index ==o.index){
            return 0;
        }
        if(index == o.index){
            if(val<o.val){
                return 11;
            }
            else{
                return 1;
            }
        }
        if(index < o.index){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "stua{" +
                "val=" + val +
                ", index=" + index +
                '}';
    }
}
/*
3 3 3
2 3 4

 */
