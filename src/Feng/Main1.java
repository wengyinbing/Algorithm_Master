package Feng;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/20 15:20
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(";");

        if(s == null){
            System.out.println(0);
        }
        else {
            int n = s.length;
            int m = s[0].split(",").length;
            int[][] array = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            //System.out.println(visit[0][0]);
            for(int i=0;i<n;i++){
                String[] ss = s[i].split(",");
                for(int j=0;j<m;j++){
                    array[i][j] = Integer.valueOf(ss[j]);
                }
            }
            if(m==1 && n==1 && array[0][0] == 1){
                System.out.println(1);
            }
            else if(array[n-1][m-1] == 0 || array[0][0] == 0){
                System.out.println(0);
            }
            else{
                //int res=1;
                Point p = new Point(0,0);
                p.l = 1;
                LinkedList<Point> queue = new LinkedList<>();
                int[][] d ={{0,1},{0,-1},{-1,0},{1,0}};
                visit[0][0] = true;
                queue.add(p);
                while(!queue.isEmpty()){
                    Point temp = queue.poll();
                    Point q  = new Point(temp.x,temp.y);
                    //visit[q.x][q.y] = true;
                    for(int k=0;k<4;k++) {
                        q.x = temp.x + d[k][0];
                        q.y = temp.y + d[k][1];
                        if(q.x==n-1 &&q.y ==m-1){
                            System.out.println(temp.l+1);
                            break;
                        }
                        if (q.x >= 0 && q.x < n && q.y >= 0 && q.y < m && !visit[q.x][q.y] && array[q.x][q.y] == 1) {
                            Point pp = new Point(q.x,q.y);
                            pp.l = Math.min(pp.l,temp.l + 1);
                            queue.add(pp);
                            visit[q.x][q.y] = true;

                        }
                    }
                }

            }

        }

    }
}
/*
1,0,1,1;1,1,1,1;1,1,0,1;0,0,0,1
 */
/*
输出没写
 */

class Point{
    public int x;
    public int y;
    public int l;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.l = Integer.MAX_VALUE;
    }
    public void add(int x,int y){
        this.x += x;
        this.y += y;
    }

}
