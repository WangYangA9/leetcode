/**
 * @Author: WangYang
 * @Date: 2019/5/15 14:03
 * @Description:
 */


import java.util.LinkedList;
import java.util.Queue;

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
    public int maxDepth(TreeNode root) {
        //解法一： 使用队列遍历所有节点
//        if(root == null) return 0;
//        int depth = 0;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        //根节点加入队列
//        queue.offer(root);
//        int thisLevelCount = 1;
//        int newLevelCount = 0;
//
//        while(queue.size() != 0){
//            TreeNode node = queue.poll();
//            thisLevelCount--;
//            if(node.left != null) {
//                queue.offer(node.left);
//                newLevelCount++;
//            }
//            if(node.right != null) {
//                queue.offer(node.right);
//                newLevelCount++;
//            }
//            if(thisLevelCount == 0){
//                thisLevelCount = newLevelCount;
//                newLevelCount = 0;
//                depth++;
//            }
//        }
//        return depth;
        //解法二：递归
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}