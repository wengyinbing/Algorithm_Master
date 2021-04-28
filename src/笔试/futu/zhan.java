package 笔试.futu;

import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/3/27 17:12
 **/
public class zhan {
    public static void main(String[] args) {
        int[] a = {2,1,5,3,4};
        int[] ok = new int[a.length];
        Arrays.fill(ok,1);
        int[] result = new int[a.length];
        for(int i =0;i<a.length;i++){
            int index = -1;
            int max = -100000007;
            int min = -100000007;
            for(int j = 0;j<a.length;j++) {
                if (ok[j] == 1) {
                    if (a[j] > max) {
                        max = a[j];
                        index = j;
                    }
                }
            }
            result[i] = max;
            ok[index] = 0;
            a[index] = min;
            if(i==a.length-1){
                break;
            }
            if(index != 0){
                index --;
            }
            while(a[index] == min){
                index--;
                if(index == -1){
                    break;
                }
            }
            ok[index] = 1;
            for(int j=0;j<index-1;j++){
                ok[j] = 0;
            }


        }
        System.out.println(Arrays.toString(result));
    }
}
