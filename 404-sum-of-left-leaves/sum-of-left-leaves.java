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
    public int sumOfLeftLeaves(TreeNode root) {
        int temp = 0;
        if (root == null) return 0;
        // if there is a left root
        if (!(root.left == null)) {
            // and it's a leaf
            if ((root.left.left == null) && (root.left.right == null)) temp = root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + temp;
    }
}
/*

if this.left is not null, return val to sum
base case: if root is null, return 0;
if left and right exist, call the recursive solution with both
    return recursive(left) + recursive(right) + this.left.val

*/