package 笔试.wanmeishijie.t2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/27 19:02
 **/
public class Main {
    public static void method(int[][] weightArray){
        int[] distance = new int[5];
        boolean[] visit = new boolean[5];
        Arrays.fill(visit,false);
        Arrays.fill(distance,9999);
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=1;i<5;i++){
            if(weightArray[0][i]!=-1){
                distance[i] = weightArray[0][i];
                ll.add(i);
                visit[i] = true;
            }
        }
        while(ll.size()>0){
            int node = ll.getFirst();
            ll.remove(0);
            for(int i=0;i<5;i++){
                if(weightArray[node][i]!=-1){
                    if(distance[i] > distance[node] + weightArray[node][i]){
                        distance[i] = distance[node] + weightArray[node][i];
                        ll.add(i);
                        /*if(!visit[i]){
                            visit[i] = true;
                            ll.add(i);
                        }*/
                    }
                }
            }
        }
        for(int i=1;i<5;i++){
            System.out.println(distance[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] array = new int[5][5];
        for(int i=0;i<5;i++){
            String[] values = s.nextLine().split(" ");
            for(int j=0;j<5;j++){
                array[i][j] = Integer.parseInt(values[j]);
            }
        }
        method(array);
    }
}
/*
0 1 12 -1 -1
-1 0 9 3 -1
-1 -1 0 -1 5
-1 -1 4 0 13
-1 -1 -1 -1 0

 */