package 笔试.zhongxing.t3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/24 14:39
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        HashMap<Integer,LinkedList<Integer>> hm = new HashMap<>();
        for(int i=1;i<=5;i++){
            LinkedList<Integer> mylist = new LinkedList<Integer>();
            hm.put(i,mylist);
        }
        int[] array = new int[5];
        int temp;
        for(int i=0;i<n;i++){
            Arrays.fill(array,0);
            boolean flag = true;
            temp = s.nextInt();
            hm.get(temp).addFirst(i+1);
            //System.out.println();
            for(int j=0;j<5;j++){
                if(hm.get(j+1).isEmpty()){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int j=0;j<5;j++){
                    array[j] = hm.get(j+1).getFirst();
                    hm.get(j+1).remove(0);
                }
                for(int j=0;j<5;j++){
                    System.out.print(array[j]);
                    if(j==4){
                        System.out.println();
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
/*
10
1 1 2 2 3 3 4 5 4 5

 */
