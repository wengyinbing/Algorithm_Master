package IO;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/19 19:22
 **/
public class Main {
    public static void main(String[] args) {
        //t组输入
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        //System.out.println(test);
        for(;test>0;test--){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + " " + b);
            scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println("输出: " + s + "\n");
        }
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String[] x = s.split(" ");
            for(String ss : x){
                System.out.println(ss);
            }
        }
    }
}
