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
    public int kthSmallest(TreeNode root, int k) {
        // return naive(root, k);
        return optimal(root, k);
    }

    // --------- optimal ----------

    private static int optimal(TreeNode root, int k) {
        int[] ans = new int[2];
        // ans[0] = counter
        // ans[1] = value

        solver(root, k, ans);
        return ans[1];
    }

    private static void solver(TreeNode root, int k, int[] ans) {
        if (root == null)
            return;
        
        solver(root.left, k, ans);

        ans[0] += 1;
        if (ans[0] == k) {
            ans[1] = root.val;
            return;
        }
        
        solver(root.right, k, ans);
    }

    // --------- naive ----------

    private static int naive(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return arr.get(k-1);
    }

    private static void inorder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}