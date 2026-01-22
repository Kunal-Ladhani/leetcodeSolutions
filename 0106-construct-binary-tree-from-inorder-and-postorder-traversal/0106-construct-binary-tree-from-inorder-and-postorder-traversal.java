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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeUtil(inorder, 0, n-1, postorder, 0, n-1);
    }
    
    private TreeNode buildTreeUtil(int[] inorder, int inStart, int inEnd, 
    int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        // Pick current node from Postorder traversal using postIndex and decrement postIndex
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root node in inorder traversal
        int rootIndex = searchRootVal(inorder, inStart, inEnd, rootVal);
        
        // LST
        int leftSize = rootIndex - inStart;
        root.left = buildTreeUtil(inorder, inStart, rootIndex - 1,
         postorder, postStart, postStart + leftSize - 1);

        // RST
        int rightSize = inEnd - rootIndex;
        root.right = buildTreeUtil(inorder, rootIndex + 1, inEnd,
         postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }

    private static int searchRootVal(int[] arr, int start, int end, int value) {
        int i = start;
        while (i <= end) {
            if (arr[i] == value) {    
                break;
            }
            i++;
        }
        return i;
    }

}