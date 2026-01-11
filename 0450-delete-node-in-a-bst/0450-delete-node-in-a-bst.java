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
    private static int findLeftMax(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        TreeNode curr = root;
        while (curr != null) {
            ans = Math.max(ans, curr.val);
            curr = curr.right;
        }
        return ans;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val == key) {
            // it doesn't have a child
            if (root.left == null && root.right == null)
                return null;
            
            // it has 1 child
            if (root.left == null || root.right == null) { 
                if (root.left == null)
                    return root.right;
                else
                    return root.left;
            }

            // both left and right are not null, so -
            
            // option 1 - pick largest value in LST and replace with root
            int leftMax = findLeftMax(root.left);
            // delete that node from left side
            root.left = deleteNode(root.left, leftMax); 
            root.val = leftMax;
            
            // or
            // option 2 - pick smallest value in RST and replace with root
            // int rightMin = findRightMin(root.right);
            // root.right = deleteNode(root.right, rightMin);
            // root.val = rightMin;
            
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key); // left node itself might get deleted so we reutrn whatever is the new node of left.
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}