import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyang on 2019/5/14 0014.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int size = nums.length;
        /*
        //解法一： 双重for循环
        for(int i = 0 ; i < size; i++){
            for(int j = i + 1; j < size;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        */
        //解法二：使用Map内存换时间
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            Integer another = target - nums[i];
            if(map.get(another) != null){
                res[0] = i;
                res[1] = map.get(another);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}