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
    static class ForwardIterator{
        Stack<TreeNode> stk;
        public ForwardIterator(TreeNode root){
            stk = new Stack<>();
            inorderSucc(root);
        }

        public void inorderSucc(TreeNode curr){
            while(curr != null){
                stk.push(curr);
                curr = curr.left;
            }
        }
        public int peek(){
            if(hasNext() == false) return 0;
            return stk.peek().val;
        }

        public int next(){
            if(hasNext() == false) return 0;
            TreeNode curr = stk.pop();
            inorderSucc(curr.right);
            return curr.val;
        }
        public boolean hasNext(){
            return stk.size()>0;
        }
    }

    static class BackwardIterator{
        Stack<TreeNode> stk;
        public BackwardIterator(TreeNode root){
            stk = new Stack<>();
            inorderPred(root);
        }

        public void inorderPred(TreeNode curr){
            while(curr != null){
                stk.push(curr);
                curr = curr.right;
            }
        }
        public int peek(){
            if(hasPrev() == false) return 0;
            return stk.peek().val;
        }

        public int prev(){
            if(hasPrev() == false) return 0;
            TreeNode curr = stk.pop();
            inorderPred(curr.left);
            return curr.val;
        }
        public boolean hasPrev(){
            return stk.size()>0;
        }
    }

    public boolean findTarget(TreeNode root, int target) {
        if(root == null || (root.left == null && root.right == null)) return false;

        ForwardIterator left = new ForwardIterator(root);
        BackwardIterator right = new BackwardIterator(root);

        while(left.hasNext() == true && right.hasPrev() == true && left.peek()< right.peek()){
            if(left.peek() + right.peek() == target) return true;
            if(left.peek() + right.peek() < target) left.next();
            else right.prev();
        }
        return false;
    }
}
