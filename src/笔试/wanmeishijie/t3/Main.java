package 笔试.wanmeishijie.t3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/4/27 19:02
 **/
public class Main {
    public static int count(int[] weights,int load){
        int result = 0;
        Arrays.sort(weights);
        for(int i=0,j=weights.length-1;i<weights.length&&j>=0;){
            if(weights[j] >= load){
                j--;
                result += 1;
                if(j<i){
                    break;
                }
                continue;
            }
            if(weights[i] >= load){
                i++;
                result += 1;
                if(j<i){
                    break;
                }
                continue;
            }
            if(weights[i] + weights[j] <= load){
                i++;
                j--;
                result += 1;
                if(j<i){
                    break;
                }
            }
            else{
                j--;
                result += 1;
                if(j<i){
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        //Scanner s = new Scanner(System.in);
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str1 = s.split(" ");
        int[] weights = new int[str1.length];
        for(int i=0;i<str1.length;i++){
            weights[i] = Integer.parseInt(str1[i]);
        }
        int maxLoad = Integer.parseInt(br.readLine());
        //System.out.println(Arrays.toString(weights));
        //System.out.println(maxLoad);
        int c = count(weights,maxLoad);
        System.out.println(c);
    }
}
/*
80 90
100
 */