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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE, maxLevel = 0;
        int currSum = 0, currLevel = 0;
        while(q.size()>0){
            currSum=0; currLevel++;
            for(int c = q.size(); c>0;c--){
                root = q.remove();
                currSum+=root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            }
            
            if(currSum>maxSum){
                maxSum = currSum;
                maxLevel = currLevel;
            }

        }
        
        return maxLevel;
    }
}
