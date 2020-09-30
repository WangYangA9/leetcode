/**
 * Created by wangyang on 2020-08-09
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int sum = nums[i] + nums[i - 1];
            if(sum > nums[i]) {
                nums[i] = sum;
            }
            if(nums[i] > res) {
                res = nums[i];
            }
        }

        return res;
    }
}
