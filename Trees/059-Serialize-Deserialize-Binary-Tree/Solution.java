public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    // Encodes a tree to a single string ... PREORDER TRAVERSAL
    public String serialize(TreeNode root) {

        StringBuilder serial = new StringBuilder();

        serialize(root, serial);

        return serial.toString();
    }

    private void serialize(TreeNode root, StringBuilder serial) {

        if (root == null) {
            serial.append("N,");
            return;
        }

        serial.append(root.val).append(",");

        serialize(root.left, serial);
        serialize(root.right, serial);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        // Queue is easier to process than string w/ delimiter
        Queue <String> values = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserialize(values);
    }

    private TreeNode deserialize(Queue<String> values) {
        String value = values.remove();

        // PREORDER
        
        // Process ROOT
        if (value.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // Process LEFT, then RIGHT
        node.left = deserialize(values);
        node.right = deserialize(values);

        // Return this node
        return node;
    }
}