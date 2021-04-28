package 笔试.zhongxing.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/24 14:12
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n,h,u;
        n = s.nextInt();
        h = s.nextInt();
        u = s.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = s.nextInt();
        }
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));
        int count = 0;
        int sum = 0;
        int sub = u-h;
        for(int i=n-1;i>=0;i--){
            if(sum>=sub){
                break;
            }
            sum += array[i];
            count++;
            if(sum>=sub){
                break;
            }
        }
        System.out.println(count);
    }
}
/*
3 2 5
1 3 2
 */
