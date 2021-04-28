package 笔试.baidu.t2;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/11 18:54
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        //StringBuilder sb = new StringBuilder(s.nextLine());
        String ss = s.nextLine();
        ss.trim();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ss.length();i++){
            if(sb.length() >= 1 && ss.charAt(i)==sb.charAt(sb.length()-1)){

            }
            else{
                sb.append(ss.charAt(i));
            }
        }
        System.out.println(sb.toString());

    }
}
/*
DDDDoo yooouu lllovvvvvvvvvvve                 mmmmee
 */