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
    int[] preorder, inorder;
    
    public int search(int val){
        for(int i=0; i < inorder.length; i++)
            if(inorder[i]==val) return i;
        return -1;
    }

    public TreeNode construct(int rootidx, int low, int high){
        if(low>high) return null;
        if(low==high) return new TreeNode(preorder[rootidx]);

        TreeNode root = new TreeNode(preorder[rootidx]);
        int mid = search(preorder[rootidx]);
        root.left = construct(rootidx + 1,low, mid-1);
        root.right = construct(rootidx + 1 + mid-low, mid+1, high);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        this.inorder = inorder;
        this.preorder = preorder;
        return construct(0,0, inorder.length-1);
    
    }

    }
