package 笔试.duxiaoman.t1;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/11 15:57
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        boolean[] light = new boolean[n];
        int[] value = new int[n];
        Arrays.fill(light,true);
        Arrays.fill(value,0);
        int temp = 0;
        for(int i=0;i<m;i++){
            temp = s.nextInt();
            for(int j = temp-1;j<n;j++){
                if(light[j]){
                    //light[j] = !light[j]
                    value[j]  = i + 1;
                }
                light[j] = !light[j];
            }
            System.out.println(Arrays.toString(light));
            System.out.println(Arrays.toString(value));
        }
        for(int i=0;i<n;i++){
            System.out.print(value[i]);
            if(i==n-1){
                System.out.println();
            }
            else{
                System.out.print(" ");
            }
        }
    }
}
/*
4 2
2 1
 */
