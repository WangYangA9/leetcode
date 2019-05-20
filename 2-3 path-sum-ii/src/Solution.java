/**
 * @Author: WangYang
 * @Date: 2019/5/20 13:36
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        sum(root, sum, temp, res);

        return res;
    }

    public void sum(TreeNode root, int num, List<Integer> temp, List<List<Integer>> res){
        if(root == null){
            return;
        }
        if (root.left == null && root.right == null) {
            if(num == root.val){
                temp.add(root.val);
                List<Integer> s = new ArrayList<>(temp);
                res.add(s);
                //还原temp
                temp.remove(temp.size() - 1);
            }
            return;
        }
        temp.add(root.val);
        sum(root.left, num - root.val, temp, res);
        sum(root.right, num - root.val, temp, res);
        temp.remove(temp.size() - 1);
    }
}