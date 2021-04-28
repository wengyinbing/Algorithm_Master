package leetcode.dp;

/**
 * @author wengyinbing
 * @data 2021/3/30 10:49
 **/
public class dp474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int m1 = 0;
        int n1 = 0;
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i = 1;i <= strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int[] arr = computeOneandZero(strs[i-1]);
                    if(j < arr[0] || k < arr[1]){
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                    else{
                        //System.out.println(strs[i-1]);
                        dp[i][j][k] = Math.max(dp[i-1][j-arr[0]][k-arr[1]]+1,dp[i-1][j][k]);
                        //System.out.println(dp[i][j][k]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] computeOneandZero(String str){
        int[] arr = {0,0};
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '0'){
                arr[0] += 1;
            }
            else{
                arr[1] += 1;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        dp474 d = new dp474();
        int m = 5;
        int n = 3;
        String[] str= {"10", "0001", "111001", "1", "0"};
        int result = d.findMaxForm(str,m,n);
        System.out.println(result);
    }
}
