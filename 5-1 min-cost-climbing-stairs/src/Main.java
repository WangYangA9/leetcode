/**
 * @Author: WangYang
 * @Date: 2019/5/16 11:15
 * @Description:
 */
public class Main {
    public static void main(String[] args){
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
