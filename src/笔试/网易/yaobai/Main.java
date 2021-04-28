package 笔试.网易.yaobai;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/27 15:35
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }
        int length = 0;
        int flag = 0;//0表示递增，该出现
        int ll = 1;
        int z = 0;
        int j = 0;
        for(int i=0;i < n-1;i++){
            if(a[i+1] > a[i]){
                flag += 1;
                z += 1;
            }
            else if(a[i+1] < a[i]){
                flag -= 1;
                j += 1;
            }
            else{
                if(ll == 1){
                    ll = 0;
                }
                if(z >= 2 && j >= 2){
                    length = Math.max(ll,length);}
                ll = 1;
                flag = 0;
                z = 0;
                j = 0;
                continue;
            }
            if(flag >= -2 && flag <= 2){
                ll += 1;
            }
            else{
                if(ll == 1){
                    ll = 0;
                }
                if(z >= 2 && j >= 2){
                length = Math.max(ll,length);}
                ll = 1;
                flag = 0;
                z = 0;
                j = 0;
            }
        }
        if(ll == 1){
            ll = 0;
        }
        if(z >= 2 && j >= 2){ length = Math.max(ll,length);}

        System.out.println(length);
    }
}
/*
6
1 2 3 2 2 1
5
1 2 3 2 1
6
-1 2 1 0 1 0
 */
