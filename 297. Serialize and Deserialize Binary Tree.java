/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
    
        StringBuilder res = new StringBuilder();
        while(q.size()>0){
            root = q.removeFirst();
            if(root == null){
                res.append("N,");
                continue;
            }
            res.append(root.val+",");
            q.addLast(root.left);
            q.addLast(root.right);

        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes[0].equals("N") == true) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int idx = 1;

        while(q.size()>0){
            TreeNode curr = q.removeFirst();

            if(nodes[idx].equals("N") == false){
                curr.left = new TreeNode(Integer.parseInt(nodes[idx]));
                q.addLast(curr.left);
            }
            idx++;
            if(nodes[idx].equals("N") == false){
                curr.right = new TreeNode(Integer.parseInt(nodes[idx]));
                q.addLast(curr.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
