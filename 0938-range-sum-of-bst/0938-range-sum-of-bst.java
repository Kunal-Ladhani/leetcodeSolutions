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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] res = new int[1];
        helper(root, low, high, res);
        return res[0];    
    }

    private static void helper(TreeNode root, int l, int h, int[] res) {
        if (root == null)
            return;

        if (root.val >= l && root.val <= h)
            res[0] += root.val;
        
        helper(root.left, l, h, res);
        helper(root.right, l, h, res);
    }
}