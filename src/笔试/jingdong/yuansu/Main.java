package 笔试.jingdong.yuansu;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/27 19:20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String is = s.nextLine();
        //System.out.println(is);
        int c = 12;
        int h = 1;
        int o = 16;
        int n = 14;
        int num = 1;
        int base = 0;
        int sum = 0;
        int index = 0;
        while(is.charAt(index)>='0' && is.charAt(index)<='9'){
            index++;
            if(index==is.length()){
                break;
            }
        }
        for(int i=0;i<is.length();i++){
            if(is.charAt(i)=='C'){
                base = c;
            }
            else if(is.charAt(i)=='H'){
                base = h;
            }
            else if(is.charAt(i)=='O'){
                base = o;
            }
            else if(is.charAt(i)=='N'){
                base = n;
            }
            else{
                int begin = i;
                while(is.charAt(i)>='0' && is.charAt(i)<='9'){
                    i++;
                    if(i==is.length()){
                        break;
                    }
                }
                num = Integer.valueOf(is.substring(begin,i));
                num = num - 1;
                i--;
            }
            sum = sum + base * num ;
            num = 1;
        }
        System.out.println(sum);
    }

}
/*
C4H9OH
 */