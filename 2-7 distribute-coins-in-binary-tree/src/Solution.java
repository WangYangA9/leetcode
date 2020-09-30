/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode t) {
        if(t == null){
            return 0;
        }
        int l = dfs(t.left);
        int r = dfs(t.right);
        ans += Math.abs(l) + Math.abs(r);
        return l + r + t.val - 1;
    }
}