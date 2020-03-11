class Solution {
    //解法1：顺序遍历
//    public int peakIndexInMountainArray(int[] A) {
//        int ans = 0;
//        for(int i = 1; i < A.length; i++){
//            if(A[i] > A[i - 1]) {
//                ans = i;
//            }
//        }
//        return ans;
//    }
    //解法2： 二分法
    public int peakIndexInMountainArray(int[] A) {
        int r = A.length - 1;
        int l = 0;
        while(l < r) {
            int mid = (l + r) / 2;
            if(A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}