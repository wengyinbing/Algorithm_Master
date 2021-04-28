package leetcode.dp;

import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/4/10 10:12
 **/
public class dp005 {
    /*
    最长回文子串
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        int begin = 0;
        int end = 0;
        int maxn = 1;
        int[][] f = new int[length][length];
        for(int i=0;i<length;i++){
            Arrays.fill(f[i],0);
        }
        for(int i=0;i<length;i++){
            for(int j = 0,k = i+j;j < length && k < length;j++,k = i + j){
                System.out.println(j + " " + k);
                if(k == j){
                    f[j][k] = 1;

                }
                else if(k == j + 1){
                    if(s.charAt(k) == s.charAt(j)){
                        f[j][k] = 2;

                    }
                }
                else{
                    if(f[j+1][k-1]>=1 && s.charAt(j) == s.charAt(k)){
                        f[j][k] = f[j+1][k-1] + 2;
                    }
                }
                if(f[j][k] > maxn){
                    maxn = f[j][k];
                    begin = j;
                    end = k;
                }
            }
        }
        return s.substring(begin,end+1);
    }

    public static void main(String[] args) {
        dp005 dp = new dp005();
        String s = dp.longestPalindrome("ccc");
        System.out.println(s);
    }
}
