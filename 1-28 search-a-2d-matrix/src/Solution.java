class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while(i < m){
            if(i + 1 < m && target >= matrix[i+1][0]){
                i++;
            } else {
                break;
            }
        }
        int j = 0;
        while(j < n){
            if(target == matrix[i][j]){
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] arr = new int[][]{{1}, {3}};
        System.out.println(searchMatrix(arr, 3));
    }
}