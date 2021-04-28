package 笔试.jingdong.SHUIKENG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/27 20:07
 **/
public class Main {
    public static void main(String[] args) {
       // while (true) {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            int[][] visit = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 || i == n - 1 || j == m - 1 || j == 0) {
                        visit[i][j] = 0;
                    } else {
                        visit[i][j] = 1;
                    }
                }
            }
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    int count = 0;
                    if (visit[i - 1][j] == 0 && arr[i - 1][j] <= arr[i][j]) {
                        visit[i][j] = 0;
                        //break;
                    } else if (visit[i][j - 1] == 0 && arr[i][j - 1] <= arr[i][j]) {
                        visit[i][j] = 0;
                        //break;
                    } else if (visit[i + 1][j] == 0 && arr[i + 1][j] <= arr[i][j]) {
                        visit[i][j] = 0;
                        //break;
                    } else if (visit[i][j + 1] == 0 && arr[i][j + 1] <= arr[i][j]) {
                        visit[i][j] = 0;
                        //break;
                    }
                    if(arr[i - 1][j] <= arr[i][j]){
                        count++;
                    }
                    if(arr[i+1][j] <= arr[i][j]){
                        count++;
                    }
                    if(arr[i][j-1] <= arr[i][j]){
                        count++;
                    }
                    if(arr[i][j+1] <= arr[i][j]){
                        count++;
                    }
                    if(count==4){
                        visit[i][j] = 0;
                    }
                }
            }
            int num = 0;
            LinkedList<point> l = new LinkedList<>();
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if(visit[i][j] == 1){
                        visit[i][j] = 0;
                        num++;
                        l.addLast(new point(i,j));
                        while(!l.isEmpty()){
                            point temp = l.pollLast();
                            int x = temp.x;
                            int y = temp.y;
                            if(visit[x+1][y]==1){
                                l.addLast(new point(x+1,y));
                                visit[x+1][y] = 0;
                            }
                            if(visit[x-1][y]==1){
                                l.addLast(new point(x-1,y));
                                visit[x-1][y] = 0;
                            }
                            if(visit[x][y+1]==1){
                                l.addLast(new point(x,y+1));
                                visit[x][y+1] = 0;
                            }
                            if(visit[x][y-1]==1){
                                l.addLast(new point(x,y-1));
                                visit[x][y-1] = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(num);
            /*for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(visit[i]));
            }*/
        }
   // }
}
/*
4 4
2 3 5 1
4 1 2 3
1 5 4 2
1 2 2 2
4 4
1 1 1 1
1 5 5 1
1 5 5 1
1 1 1 1

5 5
1 1 1 1 1
1 5 0 5 1
1 0 5 0 1
1 5 0 5 1
1 1 1 1 1
 */

class point{
    public int x;
    public int y;
    public point(int x,int y){
        this.x = x;
        this.y = y;
    }
}