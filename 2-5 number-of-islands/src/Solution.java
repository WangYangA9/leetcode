class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int r, int c){
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}