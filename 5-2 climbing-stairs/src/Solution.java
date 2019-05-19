import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangYang on 2019/5/18 0018.
 */
class Solution {
    public int climbStairs(int n) {
        //解法1： 递归，显然会超时
//        if(n == 1){
//            return 1;
//        } else if(n == 2) {
//            return 2;
//        } else {
//            return climbStairs(n - 1) + climbStairs(n - 2);
//        }
        //解法2使用list记录
//        if(n == 1){
//            return 1;
//        } else if(n == 2) {
//            return 2;
//        } else {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(1);
//            temp.add(2);
//
//            for(int i = 2; i < n; i++){
//                temp.add(temp.get(i - 2) + temp.get(i - 1));
//            }
//            return temp.get(n - 1);
//        }
        //解法3： 使用1数组
        if (n == 1) {
            return 1;
        }
        int[] temp = new int[n];
        temp[0] = 1; temp[1] = 2;
        for(int i = 2 ; i < n; i++){
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n-1];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}