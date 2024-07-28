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
    HashMap<Integer, Integer> in = new HashMap<>();
    public TreeNode construct(int[] postorder, int i, int l, int r){
        if(l>r) return null;
        TreeNode root = new TreeNode(postorder[i]);

        int j = in.get(postorder[i]);
        root.left = construct(postorder, i-(r-j) - 1, l, j-1);
        root.right = construct(postorder, i - 1, j + 1, r);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i< inorder.length; i++)
            in.put(inorder[i],i);
        return construct(postorder, postorder.length-1, 0, inorder.length-1);
        
        
    }
}
