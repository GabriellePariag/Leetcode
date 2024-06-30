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
        int h = height(root);
        return currentLevel(root, 1, h);
    }
    
    public int currentLevel(TreeNode root, int level, int h) {
        int leftHalf;
        int rightHalf;
        if (root == null) return 0;
        if (root.left == null && root.right == null && level == h)
            return root.val;
        else {
            leftHalf = currentLevel(root.left, level+1, h);
            rightHalf = currentLevel(root.right, level+1, h);
        }
        return leftHalf+rightHalf;
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        else {
            
            // Compute  height of each subtree
            int lheight = height(root.left);
            int rheight = height(root.right);

            // use the larger one
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
}
