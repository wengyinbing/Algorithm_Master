package 笔试.tencent.T5.T2;

import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/18 19:34
 **/
public class Main {
    public static int findMinx(int[] index,int[] array){
        int min = 1000000007;
        int min_index = -1;
        for(int i=0;i<index.length;i++){
            if(index[i] * array[i] < min){
                min = index[i] * array[i];
                min_index = i;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] array = new int[n];
        int[] index = new int[n];
        int[] result = new int[k];
        for(int i = 0;i<n;i++){
            array[i] = s.nextInt();
        }
        Arrays.fill(index,1);
        int min_index = -1;
        for(int i=0;i<k;i++){
            min_index = findMinx(index,array);
            index[min_index] += 1;
            result[i] = min_index+1;
        }
       for(int i=0;i<k;i++){
           System.out.println(result[i]);
       }
    }
}
/*
3 3
3
6
9
3 5
3
6
9
 */
