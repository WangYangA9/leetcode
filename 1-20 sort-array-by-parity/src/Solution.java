class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;
        while(l < r){
            while(A[l] % 2 == 0 && l < r){
                l++;
            }
            while(A[r] %2 != 0 && l < r){
                r--;
            }
            if(l < r) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }
        return A;
    }
}