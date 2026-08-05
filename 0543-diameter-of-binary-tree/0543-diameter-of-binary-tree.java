/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return diameter;
    }

    public int findHeight(TreeNode root){
        if(root == null) return -1;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        diameter = Math.max(diameter , lh+rh + 2);
        return Math.max(lh, rh) + 1;
    }
}