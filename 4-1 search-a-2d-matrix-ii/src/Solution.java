/**
 * @Author: WangYang
 * @Date: 2019/5/16 12:36
 * @Description:
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        //解法1：选取右上或左下角开始移动
        int i = 0, j = matrix[0].length - 1, iMax =  matrix.length;
        while(i < iMax && j >= 0){
            if(target < matrix[i][j]) {
                j--;
            } else if(target > matrix[i][j]){
                i++;
            } else {
                return true;
            }
        }
        return false;
        //解法2：二分法
//        int iMax = matrix.length, jMax = matrix[0].length;
//        return recuice(matrix, 0, iMax, 0, jMax, target);
    }

    boolean recuice(int[][] matrix, int up, int down, int left, int right, int target){
        int midi = (up + down) / 2;
        int midj = (left + right) / 2;

        if(up >= down || left >= right){
            return false;
        }
        if(target < matrix[midi][midj]){
            return recuice(matrix, up, midi, left, right, target) || recuice(matrix, up, down, left, midj, target);
        } else if(target > matrix[midi][midj]){
            return recuice(matrix, midi + 1, down, left, right, target) || recuice(matrix, up, down, midj + 1, right, target);
        }else {
            return true;
        }
    }
}