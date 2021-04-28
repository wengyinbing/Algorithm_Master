package leetcode.dp;

/**
 * @author wengyinbing
 * @data 2021/4/10 15:30
 * 编辑距离
 * 一般求解字符串的动态规划问题，
 * 一般使用两个指针，指向字符串的最后
 * 递归从顶向下
 * 优化方法 dp数组备忘录
 * 自底向上
 * 如果要保存路径的话，新建一个数据结构Node val记录步长 chioce记录选择的操作，每记得更新。
 **/
public class dp072 {
    public int minDistance(String word1, String word2) {
        return 1;
    }

    public static void main(String[] args) {
        dp072 d = new dp072();
        String s1 = "horse";
        String s2 = "ros";
        int result = d.minDistance(s1,s2);
        System.out.println(result);
    }
}
