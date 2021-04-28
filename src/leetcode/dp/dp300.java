package leetcode.dp;

import java.util.Arrays;

/**
 * @author wengyinbing
 * @data 2021/3/30 13:48
 **/
public class dp300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null){
            return 0;
        }
        int result = 1;
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for(int i=1;i<length;i++)
        {
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    //System.out.println(j + " " + i);
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            result = Math.max(dp[i],result);//查找中间的最大值
        }
        return result;
    }

    /*
    可以使用贪心二分做
     */

    public static void main(String[] args) {
        dp300 s = new dp300();
        int[] nums = {10,9,2,5,3,7,101,18};
        int result = s.lengthOfLIS(nums);
        System.out.println( result);
    }
}
