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
    TreeNode curr = null;
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        System.out.println(first.val);
        System.out.println(second.val);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;

        }
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        curr = root;
        if (prev != null) {
            if (prev.val > curr.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }

        }
        prev = curr;
        inorderTraversal(root.right);
    }
}