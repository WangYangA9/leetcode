class Solution {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[l] < nums[mid]){
                if(nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = new int[]{3,1};
        search(arr, 1);
    }
}