package 笔试.网易.qiuhe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/27 16:04
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }
        //Arrays.sort(a);

        if(a.length < 1){
            System.out.println(-1);
        }
        if(a.length == 1){
            if(a[0] % 6 == 0){
                System.out.println(a[0]);
            }
            else{
                System.out.println(-1);
            }
        }
        int max = -1;
        int[][] sum = new int[2][n];
        int[][] fail = new int[2][n];
        Arrays.fill(sum,0);
        Arrays.fill(fail,0);
        if(a[0] % 6 == 0){
            sum[1][0] = a[0];
        }
        else{
            fail[1][0] = a[0];
        }
        for(int i=1;i<a.length;i++){
            int s1 = sum[0][i-1] + a[i];
            int s2 = sum[1][i-1] + a[i];
            int f1 = fail[0][i-1] + a[i];
            int f2 = fail[1][i-1] + a[i];
            if(s2 % 6 == 0){
                sum[1][i] = s2;
            }
            else{
                fail[1][i] = s2;
            }
        }
    }
}
/*
4
6 8 4 3
3
2 3 5
 */
