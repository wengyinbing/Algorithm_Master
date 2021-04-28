package leetcode.dp;

import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/4/10 14:16
 * 最长子序列和 一维数组实现
 **/
public class dp053 {
    public int maxSubArray(int[] nums) {
        int maxn = -10000000;
        int length = nums.length;
        int[] dp = new int[length];
        for(int i=0;i<length;i++){
            dp[i] = nums[i];
        }
        for(int i=0;i<length;i++){
            if(i>0) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                System.out.println(dp[i]);
            }
                if(dp[i] > maxn){
                    maxn = dp[i];
                }
        }
        return maxn;
    }

    public static void main(String[] args) {
        dp053 d = new dp053();
        int[] nums = {5,4,-1,7,8};
        int result  = d.maxSubArray(nums);
        System.out.println(result);
    }

}
