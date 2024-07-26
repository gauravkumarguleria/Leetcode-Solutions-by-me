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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> values = new ArrayList<>();
            int size = queue.size();

            for(int i = 0 ; i<size; i++){
                TreeNode node = queue.poll();
                values.add(node.val);

                if(node.left!= null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(0,values);
        }
        return result;
    }
}
