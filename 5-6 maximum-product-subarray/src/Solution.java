/**
 * Created by wangyang on 2020-08-10
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int m = nums.length;

        int[] min = new int[m];
        int[] max = new int[m];
        min[0] = nums[0];
        max[0] = nums[0];
        int res = nums[0];
        for(int i = 1; i < m; i++) {
//            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
//            min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
            if(nums[i] >= 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            if(max[i] > res) res = max[i];
        }
        return res;
    }
}
