class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int res = reserve(grid, i, j, 0);
                if(res > ans){
                    ans = res;
                }
            }
        }
        return ans;
    }
    public int reserve(int[][] grid, int r, int c, int res){
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0){
            return res;
        }
        res++;
        grid[r][c] = 0;
        res = reserve(grid, r + 1, c, res);
        res = reserve(grid, r - 1, c, res);
        res = reserve(grid, r, c + 1, res);
        res = reserve(grid, r, c - 1, res);
        return res;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        Solution s = new Solution();
        System.out.println(s.maxAreaOfIsland(grid));
    }
}