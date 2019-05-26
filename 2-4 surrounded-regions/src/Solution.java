/**
 * Created by Administrator on 2019/5/21 0021.
 */
class Solution {
    public void solve(char[][] board) {
        //方法1：每个与边界连接的O变成P  其他的全部换成X 再把P换成O
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return;
        }
        int cols = board.length;
        int rows = board[0].length;
        for(int i = 0; i < cols; i++){
            dfs(board, i, 0);
            dfs(board, i, rows - 1);
        }
        for(int i = 0; i < rows; i++){
            dfs(board, 0, i);
            dfs(board, cols - 1, i);
        }
        for(int i = 0 ; i < cols; i++){
            for(int j = 0; j < rows; j++){
                if(board[i][j] == 'P'){
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'P';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args){
        char[][] board = new char[][]{
            {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        Solution solution = new Solution();
        solution.solve(board);

        System.out.print(board);
    }
}