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
    public static class Pair{int yes, no;}
    public Pair dfs(TreeNode root){
        if(root == null) return new Pair();

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        Pair curr = new Pair();
        curr.no = l.yes +r.yes;
        curr.yes = Math.max(curr.no, root.val + l.no + r.no);
        return curr;
        
    }
    public int rob(TreeNode root) {
        return dfs(root).yes;
    }
}
