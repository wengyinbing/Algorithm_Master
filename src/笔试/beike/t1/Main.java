package 笔试.beike.t1;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/4/12 20:23
 **/
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        if(n<=0){
            System.out.println(0);
        }
        for(int i=0;i<n;i++){
            int temp = sc.nextInt();
            if(hm.containsKey(temp)){
                hm.put(temp,hm.get(temp)+1);
            }
            else{
                hm.put(temp,1);
            }
        }
        //System.out.println(hm.descendingKeySet().size());
        int m = hm.descendingKeySet().size();
        int[] array = new int[m];
        int kk= 0;
        for(int i:hm.descendingKeySet()){
            array[kk++] = i;
        }
        int result = hm.get(array[0]);
        //System.out.println(hm);
       // System.out.println(result);
        int sum = 0;
        for(int j=1;j<m;j++){
            sum = 0;
            for(int k=j;k<m;k++){
                //System.out.println(array[k] + " "+ hm.get(array[k]));
                sum = sum + (hm.get(array[k]) * array[k]);
                if(sum >= array[0]){
                    result += hm.get(array[j]);
                    break;
                }
            }
        }
        System.out.println(result);
    }
 }

/*
4
6 6 2 3
 */