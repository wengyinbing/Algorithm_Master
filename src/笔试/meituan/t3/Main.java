package 笔试.meituan.t3;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/4/11 11:01
 **/
public class Main {
    public static int[] solve(String s,int num,int n){
        char c = '0';
        if(n==1){
            c = '1';
        }
        int[] result = {0,0,0};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            int count = 0;
            if(list.size() >= 3){
                if(list.get(list.size()-1)==n){
                    count += 1;
                }
                if(list.get(list.size()-2)==n){
                    count += 1;
                }
                if(list.get(list.size()-3)==n){
                    count += 1;
                }
                if(count>=2){
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    if(n==0){
                        result[0] = result[0] + count;
                        result[1] = result[1] + (3-count);
                    }
                    else{
                        result[1] = result[1] + count;
                        result[0] = result[0] + (3-count);
                    }
                }
                else{
                    list.add(s.charAt(i)-'0');
                }
            }
            else{
                list.add(s.charAt(i)-'0');
            }
           // System.out.println(list);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String ss = s.next();
        int num0 = 0;
        int num1 = 0;
        for(int i=0;i<n;i++){
            if(ss.charAt(i) == '0'){
                num0 += 1;
            }
            else{
                num1 += 1;
            }
        }
        if(num0 == n || num1 == n){
            System.out.println(n);
        }
        else if(num0 == 1|| num1 == 1){
            System.out.println(n-2);
        }
        else{
            int[] result = {0,0};
            int maxn = -1;
            result = Main.solve(ss,n,0);
            System.out.println(Arrays.toString(result));
            if(num0-result[0] -(num1-result[1])>maxn){
                maxn = num0-result[0] -(num1-result[1]);
            }
            if((num1-result[1])-(num0-result[0])>maxn){
                maxn = (num1-result[1])-(num0-result[0]);
            }
            result = Main.solve(ss,n,1);
            System.out.println(Arrays.toString(result));
            if((num0-result[0]) -(num1-result[1])>maxn){
                maxn = num0-result[0] -(num1-result[1]);
            }
            if((num1-result[1])-(num0-result[0])>maxn){
                maxn = (num1-result[1])-(num0-result[0]);
            }
            System.out.println(maxn);
        }
    }
}
