package 笔试.baidu.t1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wengyinbing
 * @data 2021/4/11 18:52
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        //System.out.println(ss);
        StringBuilder sb = new StringBuilder(ss.trim());
        for(int i=0;i<sb.length();i++){
           if(sb.charAt(i)>='a'&&sb.charAt(i)<='z'){

           }
           else if(sb.charAt(i) == ' '||sb.charAt(i) == '_'||sb.charAt(i)=='\''){

           }
           else if(sb.charAt(i) >= 'A' && sb.charAt(i) <='Z'){

           }
           else if(sb.charAt(i) >= '0' && sb.charAt(i) <='9'){

           }
           else{
               sb.deleteCharAt(i);
           }
        }
        ss = new String(sb);
        String[] slist = ss.split(" ");
        TreeMap<String,Integer> hm = new TreeMap<>();

        for(int i=0;i<slist.length;i++){
            if(slist[i].equals(" ")){
                continue;
            }
            if(hm.containsKey(slist[i].toLowerCase())){
                hm.put(slist[i].toLowerCase(),hm.get(slist[i].toLowerCase())+1);
            }
            else{
                hm.put(slist[i].toLowerCase(),1);
            }
        }
        System.out.println(hm);
        int max = -1;
        String result= null;
        for(String si:hm.keySet()){
            if(max < hm.get(si)){
                max = hm.get(si);
                result = si;
            }
        }
        for(int i=0;i<slist.length;i++){
            if(result.equals(slist[i].toLowerCase())){
                result = slist[i];
                break;
            }
        }
        System.out.println(result + " " + max);
    }
}
/*
Five Little Monkeys Jumping on the Bed. It was bedtime. So five little monkeys took a bath. Five little Monkeys put on their pajamas.
 */

