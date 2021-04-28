package 笔试.网易;

import java.util.Scanner;

/**
 * @author wengyinbing
 * @data 2021/3/27 15:18
 **/
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        ss = ss.substring(1,ss.length()-1);
        String[] sa = ss.split(",");

    }
}
/*
[3,1,5,2,4,4,1]
8
 */
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x){
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode x){
        this.val = x.val;
        this.left = x.left;
        this.right = x.right;
    }

}

class Tree{
    public TreeNode root;


    public TreeNode createTree(String[] s){
        if(s.length ==0){
            this.root = null;
        }

        return this.root;
    }
}
