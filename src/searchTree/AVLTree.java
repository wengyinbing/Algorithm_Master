package searchTree;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wengyinbing
 * @data 2021/3/12 13:54
 * 平衡二叉树
 **/
class Node{
    public Node parent;
    public Node leftChild,rightChild;
    public int data;
    public Node(Node p,Node left, Node right,int data){
        this.parent = p;
        this.leftChild = left;
        this.rightChild = right;
        this.data = data;
    }
    public Node(int data){
        this(null,null,null,data);
    }
    public Node(Node parent , int data){
        this.parent = parent;
        this.data = data;
    }
}
public class AVLTree {
    private Node root;
    private final static int LEFT = 1;
    private final static int RIGHT = -1;
    private final static int MAX_LEFT = 2;
    private final static int MAX_RIGHT = -2;

    /*
    添加数据
     */
    public void put(int data){
        putData(root,data);
    }
    /*
    中序遍历二叉树
     */
    public void print(){
        midOrderPrint(this.root);
    }
    private void midOrderPrint(Node node){
        if(node == null){
            return;
        }
        midOrderPrint(node.leftChild);
        System.out.println(node.data + "  ");
        midOrderPrint(node.rightChild);
    }
    /*
    层次遍历二叉树
    并且查看每个节点的平衡状态
     */
    public void sequenceErgodic(){
        if(this.root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        Node temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.println("当前节点值： " + temp.data + " 平衡状态为: " + getNodeBF(temp));
            if(temp.leftChild != null){
                queue.add(temp.leftChild);
            }
            if(temp.rightChild != null){
                queue.add(temp.rightChild);
            }
        }
    }
    /*
    删除数据
     */
    public boolean delete(int data){
        return false;
    }
    /*
    获得指定节点
    二分查找
     */
    public Node getNode(int data){
        Node node = this.root;
        while(node != null){
            if(node.data == data){
                return node;
            }
            else if(node.data > data){
                node = node.leftChild;
            }
            else{
                node = node.rightChild;
            }
        }
        return null;
    }
    /*
    实现添加数据的具体操作
     */
    private boolean putData(Node node,int data){
        if(node == null){//创建根节点
            Node n = new Node(data);
            this.root = n;
            return true;
        }
        Node p = null;
        Node temp = node;
        int t = 0;
        do{
            p = temp;
            t = temp.data - data;
            if(t > 0){
                temp = temp.leftChild;
            }
            else if(t < 0){
                temp = temp.rightChild;
            }
            else{//已经有该节点了，插入失败
                return false;
            }
        }while(temp!=null);
        if(t < 0){
            p.rightChild = new Node(p,data);
        }
        else if(t > 0){
            p.leftChild = new Node(p,data);
        }
        //System.out.println("insert " + data);
        rebuildTree(p);

        return false;
    }

    /*
    右旋
     */
    private Node rightRotation(Node node){
        if(node == null){
            return null;
        }
        Node left = node.leftChild;//B
        Node leftright = left.rightChild;//x
        node.leftChild = leftright;
        if(leftright != null){
            leftright.parent = node;
        }
        left.parent = node.parent;
        if(node.parent == null)//node已经是root根节点了，那么让B成为新的root
        {
            this.root = left;
        }
        else if(node.parent.leftChild == node)//查看当前node是左节点还是右节点，好为B节点取代了node的位置
        {
            node.parent.leftChild  = left;
        }
        else if(node.parent.rightChild == node){
            node.parent.rightChild = left;
        }
        left.rightChild = node;//node指向B
        node.parent = left;
        return left;
    }
    /*
    左旋
     */
    private Node leftRotation(Node node){
        if(node == null){
            return null;
        }
        Node right = node.rightChild;//B
        Node rightleft = right.leftChild;//X
        node.rightChild = rightleft;
        if(rightleft != null){
            rightleft.parent = node;
        }
        right.parent = node.parent;
        if(node.parent == null){
            this.root = right;
        }
        else if(node.parent.rightChild == node){
            node.parent.rightChild = right;
        }
        else if(node.parent.leftChild == node){
            node.parent.leftChild = right;
        }
        node.parent = right;
        right.leftChild = node;
        return right;
    }
    /*
    平衡二叉树的方法
     */
    private  void rebuildTree(Node node){
        //System.out.println("rebuildtree" + node.data);
       while(node != null) {
           System.out.println(getNodeBF(node));
           if (getNodeBF(node) == MAX_LEFT) {
               fixAfterInsertion(node, LEFT);
           } else if (getNodeBF(node) == MAX_RIGHT) {
               fixAfterInsertion(node, RIGHT);
           }
           node = node.parent;

       }
    }
    /*
    调整二叉树
     */
    private void fixAfterInsertion(Node node ,int type){
        //根据三个节点的形状判断是否是右旋还是左右旋
        if(type == LEFT){
            if(node.leftChild.leftChild != null){//右旋
                rightRotation(node);
            }
            else if(node.leftChild.rightChild != null){//左右旋
                leftRotation(node.leftChild);//有些没明白
                rightRotation(node);
            }
        }
        else if(type == RIGHT){
            if(node.rightChild.rightChild != null){
                leftRotation(node);
            }
            else if(node.rightChild.leftChild != null){
                rightRotation(node.rightChild);
                leftRotation(node);
            }
        }
    }
    /*
    计算节点的平衡因子
     */
    private int getNodeBF(Node node){
        if(node == null){
            return 0;
        }
        return  getNodeDepth(node.leftChild) - getNodeDepth(node.rightChild);
    }
    /*
    树的深度计算
     */
    private int getNodeDepth(Node node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(getNodeDepth(node.leftChild),getNodeDepth(node.rightChild));
    }
    /*
    找到节点的后继节点
    就是距离这个节点最近的最大值？？？
    如果有右子树，那么后集结点一定在这
    没有的话向上找到以这个节点为左孩子的最近的父节点。
     */
    private Node getSuccessor(Node node){
        Node temp = null;
        if(node.rightChild != null){
            temp = node.rightChild;
            while(temp.leftChild != null){
                temp = temp.leftChild;
            }
            return temp;
        }
        if(node.parent != null){
            temp = node.parent;
            while(temp.rightChild == node && temp != null){//看看当前节点是不是父节点的左孩子
                node = temp;
                temp = temp.parent;
            }
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        AVLTree bbt = new AVLTree();
        bbt.put(3);
        bbt.put(2);
        bbt.put(1);
        bbt.put(4);
        bbt.put(5);
        bbt.put(6);
        bbt.put(7);
        bbt.put(10);
        bbt.put(9);
        bbt.print();
        bbt.sequenceErgodic();
    }
}
