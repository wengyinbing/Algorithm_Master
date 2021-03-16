package Util;

import java.util.Random;

/**
 * @author wengyinbing
 * @data 2021/3/13 21:39
 **/
public class randomGenerator {
    /*
    Random
     */
    public void solve1(){
        Random r = new Random();
        System.out.println(r.nextInt(100));
    }
    /*
    Math工具类
     */
    public void solve2(int min,int max){
        System.out.println((int)(Math.random()*(max-min) + min));
    }
    public static void main(String[] args) {
        randomGenerator r = new randomGenerator();
        r.solve2(0,10);
    }
}
