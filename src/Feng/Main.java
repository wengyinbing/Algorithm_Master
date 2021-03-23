package Feng;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/3/20 14:21
 **/
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int et = 0;
        int result = 0;
        s.nextLine();
        for(int i=0;i<n;i++){
            String[] ss = s.nextLine().split(",");
            int at = Integer.valueOf(ss[0]);
            int pt = Integer.valueOf(ss[1]);
            if(i == 0){
                et = at;
            }
            result = result +(pt + et - at);
            et = pt + et;
        }
        System.out.println(result);
    }
}
/*
1-a,2-b,3-c
1-a,2-bb,3-c
1-a
1-a,2-b
1-a,2-b,3-c
1-a,2-bb
 */
/*
3
1,2
2,5
4,3
 */
