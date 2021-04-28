package 笔试.tencent.T3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/4 20:42
 **/
public class Main {

    public int solve(int[] array,int len){
        if(len==1){
            return array[0];
        }
        else if(len==2){
            return array[1];
        }
        else if(len == 3){

            return array[0] + array[1] + array[2];
        }
        else if(len == 4){
            int a = array[0] + 3*array[1]  + array[3];
            int b = array[0] * 2 + array[1] + array[2] +array[3];
            if(a<b){
                return a;
            }
            return b;
        }
        int a = array[len-1] + solve(array,len-2) + array[0] + 2*array[1];
        int b = array[len-1] + array[0] * 2 + solve(array,len-1);
        if(a<b){
            return a;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main m1 = new Main();
        for(int n1=0;n1<n;n1++){
            int m = sc.nextInt();
            int[] array = new int[m];
            for(int i=0;i<m;i++){
                array[i] = sc.nextInt();
            }
            Arrays.sort(array);
            int result = m1.solve(array,m);
            System.out.println(result);
        }

    }
}
/*
2
3
3 6 9
4
10 1 5 2
 */
