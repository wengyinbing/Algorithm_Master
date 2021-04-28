package 笔试.zhongxing.t2;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/24 14:20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        Long a;
        n = s.nextInt();
        for(int i=0;i<n;i++){
            a = s.nextLong();
           // System.out.println(a);

            double res = Math.ceil(Math.log(a)/Math.log(2));
            int result = (int)res + 1;
            System.out.println(result);
        }
    }
}
