/**
 * @Author: WangYang
 * @Date: 2019/5/16 11:15
 * @Description:
 */
public class Main {
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, 10));
    }
}
