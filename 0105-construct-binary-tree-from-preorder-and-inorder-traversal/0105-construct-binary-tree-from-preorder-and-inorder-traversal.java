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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildTreeUtil(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderIndex);
    }

    private static TreeNode buildTreeUtil(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderIndex) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        
        // root will be the first one in preorder array
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootInorderIdx = inorderIndex.get(rootVal);

        int leftSize = rootInorderIdx - inStart;
        root.left = buildTreeUtil(preorder, preStart+1, preStart+leftSize, inorder, inStart, rootInorderIdx-1, inorderIndex);

        int rightSize = inEnd - rootInorderIdx;
        root.right = buildTreeUtil(preorder, preStart+leftSize+1, preEnd, inorder, rootInorderIdx+1, inEnd, inorderIndex);

        return root;
    }
}