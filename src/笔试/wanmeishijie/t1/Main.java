package 笔试.wanmeishijie.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/27 19:01
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int weight = s.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for(int i=0;i<n;i++){
            weights[i] = s.nextInt();
        }
        for(int i=0;i<n;i++){
            values[i] = s.nextInt();
        }
        int[] dp = new int[weight+1];
        Arrays.fill(dp,-0);
        for(int j=0;j<n;j++) {
            for (int i = 0; i <=weight; i++) {
                if (i >= weights[j]) {
                    dp[i - weights[j]] = Math.max(dp[i - weights[j]], dp[i] + values[j]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }
        /*int maxn = -1;
        for(int i=0;i<=weight;i++){
            if(dp[i] > maxn){
                maxn = dp[i];
            }
        }*/
        System.out.println(dp[0]);
    }
}
/*
4
15
5 3 4 6
20 10 12 30
 */