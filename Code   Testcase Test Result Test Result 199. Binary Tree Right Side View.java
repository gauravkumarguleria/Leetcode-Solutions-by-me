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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        if(root == null) return right; 
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
       
        while(q.size()>0){
            for(int c = q.size(); c>0;c--){
                root = q.remove();
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            right.add(root.val);
        }
        
        return right;
    }
}
