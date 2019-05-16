/**
 * @Author: WangYang
 * @Date: 2019/5/16 14:46
 * @Description:
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2){
            return 0;
        } else {
            int[] dp= new int[cost.length];
            dp[0] = cost[0];
            dp[1] = cost[1];
            int size = cost.length;
            for(int i = 2; i < size; i++){
                dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i]);
            }
            return Math.min(dp[size - 1], dp[size - 2]);
        }
    }
}
