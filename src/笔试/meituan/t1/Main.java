package 笔试.meituan.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/11 10:00
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] value = new int[n];
        int[] tuan = new int[n];
        int temp = 0;
        int k = 0;
        for(int i = 0;i<n ;i++){
            temp = s.nextInt();
            if(temp == 0){
                tuan[k++] = i + 1;
            }
            value[i] = temp;
        }
        //System.out.println(Arrays.toString(value));
        //System.out.println(Arrays.toString(tuan));
        int exminx = 1000000007;
        int index = -1;
        for(int i=0;i<n;i++){
            if(value[i] <= m && value[i]!=0){
                int ex=0;
                for(int j=0;j<k;j++){
                    ex += Math.abs(tuan[j]-i-1);
                }
                if(ex<exminx){
                    exminx = ex;
                    index = i + 1;
                }
            }
        }

        System.out.println(index);
    }
}
/*
5 3
4 5 0 3 3
 */
