/**
 * Created by wangyang on 2020-08-09
 */
class Solution {
    public static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        for(int i = 0; i < m ; i++) array[i][0] = 1;
        for(int i = 0; i < n ; i++) array[0][i] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(51, 9));
    }
}