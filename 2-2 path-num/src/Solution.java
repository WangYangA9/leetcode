/**
 * @Author: WangYang
 * @Date: 2019/5/15 14:03
 * @Description:
 */


import javafx.util.Pair;

import java.util.Stack;

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        //解法1：使用递归计算每一条路径的和
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        //解法2：使用非递归方法  未完成
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new Pair<>(root, sum));
//        while(!stack.isEmpty()){
//            Pair<TreeNode, Integer> node = stack.pop();
//            if(node.getKey().val == node.getValue() && node.getKey().left == null && node.getKey().right == null){
//                return true;
//            }
//            if(node.getKey().left != null){
//                stack.push(new Pair<>(node.getKey().left, sum - node.getValue()));
//            }
//            if(node.getKey().right != null){
//                stack.push(new Pair<>(node.getKey().right, sum - node.getValue()));
//            }
//        }
//        return false;
    }
}