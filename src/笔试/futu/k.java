package 笔试.futu;

import Util.HashEquals;

import java.util.HashMap;

/**
 * @author wengyinbing
 * @data 2021/3/27 17:41
 **/
public class k {
    public static void main(String[] args) {
        int[] arr= {5,4,1,1,5,1,5};
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i: arr){
            if(h.containsKey(i)){
                h.put(i,h.get(i)+1);
            }
            else{
                h.put(i,0);
            }
        }
        for(int i:h.keySet()){
           if(h.get(i)==0){
               System.out.println(i);
               //return i;
           }
        }
    }
}
