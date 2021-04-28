package 笔试.tencent.T2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/4 20:09
 **/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String s = sc.next();
        boolean[] visit = new boolean[len];
        Arrays.fill(visit,true);
        int num = 0;
        for(int i=0,j=1;i<len&&j<len;){
            int a = s.charAt(i) - '0';
            int b = s.charAt(j) - '0';
            if(a+b == 10) {
                //System.out.println(a+" "+b);
                //System.out.println(i + " " + j);
                visit[i] = false;
                visit[j] = false;
                num += 2;
                if (i == 0) {
                    i = j + 1;
                    j = j + 2;
                }
                else {
                    while (i>=0 && visit[i] == false) {
                        i = i - 1;

                    }
                    if (i == -1) {
                        i = j + 1;
                        j = j + 2;
                    }
                    else{
                        j = j + 1;
                    }
                }

                //System.out.println(i + " " + j);
            }
            else{
                i = j;
                j = j + 1;
            }
        }
        System.out.println(len - num);
    }
}
