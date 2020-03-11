class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, t = 0;
        while(i < A.length && A[i] < 0){
            i++;
        }
        int j = i - 1;
        while(j >= 0 && i < A.length){
            int lv = A[j] * A[j];
            int rv = A[i] * A[i];
            if(lv < rv) {
                ans[t++] = lv;
                j--;
            } else {
                ans[t++] = rv;
                i++;
            }
        }
        while(j >= 0){
            ans[t++] = A[j] * A[j];
            j--;
        }
        while(i < A.length){
            ans[t++] = A[i] * A[i];
            i++;
        }
        return ans;
    }
}