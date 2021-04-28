package 笔试.meituan.t2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/11 10:21
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int num = n;
        int num1 = m;
        int maxn = -1;
        int[] mei = new int[m];
        int[] tuan = new int[n];
        for(int i=0;i<m;i++){
            mei[i] = s.nextInt();
        }
        for(int j =0;j<n;j++){
            tuan[j] = s.nextInt();
        }
        Arrays.sort(mei);
        Arrays.sort(tuan);
        int i=0;
        int j=0;
        for(;i<m&&j<n;){
            if(num-num1>maxn){
                maxn = num-num1;
                System.out.println(num + " "+ num1);
            }
            if(mei[i] < tuan[j]){
                num1 -= 1;
                i++;
            }
            else if(mei[i]==tuan[j]){
                num1 -= 1;
                num -= 1;
                i++;
                j++;;
            }
            else{
                num -= 1;
                j++;
            }

        }
        if(num-num1>maxn){
            maxn = num-num1;
            System.out.println(num + " "+ num1);
        }
        if(maxn+n-m<0){
            System.out.println(0);
        }
        else{
            System.out.println(maxn+n-m);
        }
    }
}
/*
2 3
585 375
936 317 185
 */
