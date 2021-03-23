package biancheng;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/3/19 20:23
 **/
public class Main {
    public static void main(String[] args) {
        //Main ma = new Main();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            int m = s.nextInt();
            double result = n;
            double temp = n;
            for (int i = 0; i < m-1; i++) {
                temp = Math.pow(temp, 0.5);
                //System.out.println(temp);
                result += temp;
            }
            System.out.printf("%.2f\n", result);

        }
    }

}