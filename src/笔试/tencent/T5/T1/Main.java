package 笔试.tencent.T5.T1;

import compareTest.compare1;

import java.util.*;

/**
 * @author wengyinbing
 * @data 2021/4/18 19:33
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int k=0;k<t;k++){
            int n = s.nextInt();
            List<Game> list = new ArrayList<>();
            int[] time = new int[n];
            int[] weight = new int[n];
            for(int i=0;i<n;i++){
                time[i] = s.nextInt();
            }
            for(int i=0;i<n;i++){
                weight[i] = s.nextInt();
            }
            for(int i=0;i<n;i++){
                list.add(new Game(time[i],weight[i]));
            }
            Collections.sort(list);
            int sum = list.get(0).time;
            System.out.println(sum);
            int current = 0;
            int[] result = new int[sum];
            for(Game g:list){
                if(sum>0){
                    //result[sum] = result[sum-1]
                }
            }
            System.out.println(result);
        }
    }
}
/*
1
3
3 1 1
3 6 9
 */
class Game implements Comparable<Game>{
    public int time;
    public int weight;

    public Game(int time, int weight) {
        this.time = time;
        this.weight = weight;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Game{" +
                "time=" + time +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        if(time == o.time && weight == o.weight){
            return 0;
        }
        else if(time == o.time && weight > o.weight){
            return 1;
        }
        else if(time < o.time){
            return 1;
        }
        return -1;
    }
}
