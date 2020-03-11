class Solution {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length-1;
        if(nums[l] <= nums[r]){
            return nums[l];
        }
        while(l < r){
            int mid = (l + r) /2;
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if(nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return nums[l];
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,3,5};
        System.out.println(findMin(arr));
    }
}