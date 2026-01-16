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
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> arr = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0; i<len; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            arr.add(level);
        }

        List<Integer> lastLevel = arr.get(arr.size()-1);
        int ans = 0;
        for (int i=0; i<lastLevel.size(); i++) {
            ans += lastLevel.get(i);
        }

        return ans;
    }

    
}