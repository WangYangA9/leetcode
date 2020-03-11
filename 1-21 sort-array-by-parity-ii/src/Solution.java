class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int l = 0, r = 1, length = A.length;
        while(l < length && r < length){
            while(l < length && A[l] % 2 == 0){
                l += 2;
            }
            while(l < length && A[r] %2 == 1){
                r += 2;
            }
            if(l < length && r < length) {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l += 2;
                r += 2;
            }
        }
        return A;
    }
}