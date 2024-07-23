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
    public static class Pair{
        TreeNode head , tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public Pair dfs(TreeNode root){
        if(root == null)
            return new Pair(null, null);
        if(root.left == null && root.right==null)
            return new Pair(root,root);
        
        if(root.left == null){
            Pair r = dfs(root.right);
            return new Pair(root, r.tail);

        }

        Pair l = dfs(root.left);
        Pair r = dfs(root.right);

        root.left = null;
        root.right = l.head;
        if(r.head == null){
            return new Pair(root, l.tail);
        }

        l.tail.right = r.head;
        return new Pair(root, r.tail);
    }

    public void flatten(TreeNode root) {
        dfs(root);
    }
}
