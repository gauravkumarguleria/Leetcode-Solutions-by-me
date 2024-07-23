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
    List<String> paths = new ArrayList<>();
    public void dfs(TreeNode root, String path){
        if(root == null ) return ;
        if(root.left == null && root.right == null){
            path += root.val;
            paths.add(path);
            return;
        }
        dfs(root.left, path + root.val + "->");

        dfs(root.right, path + root.val + "->");
    }

    public List<String> binaryTreePaths(final TreeNode root) {
        final List<String> result = new ArrayList<>();
        dfs(root,"");
        return paths;
        
    }

 
}
