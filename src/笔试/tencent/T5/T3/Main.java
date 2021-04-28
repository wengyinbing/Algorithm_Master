package 笔试.tencent.T5.T3;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/18 19:34
 **/
public class Main {
    public static boolean solve(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.length()%2 == 1){
            return s1.equals(s2);
        }
        String s11 = s1.substring(0,s1.length()/2);
        String s12 = s1.substring(s1.length()/2,s1.length());
        String s21 = s2.substring(0,s2.length()/2);
        String s22 = s2.substring(s2.length()/2,s2.length());
        if(solve(s11,s21) && solve(s12,s22)){
            return true;
        }
        if(solve(s11,s22) && solve(s12,s21)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int k=0;k<n;k++){
            String s1 = s.next();
            String s2 = s.next();
            if(solve(s1,s2)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
/*

4
aaba
abaa
aabb
abab
aaabbb
bbbaaa
cba
abc
 */
