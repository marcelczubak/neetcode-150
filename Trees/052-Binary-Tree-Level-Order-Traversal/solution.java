import java.util.*;

class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // Base case
        if (root == null) return new ArrayList<>();

        // Initialise queue
        Queue<TreeNode> queue = new LinkedList<>();

        // Return this list
        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {

            int n = queue.size();

            // For THIS level
            List<Integer> level = new ArrayList<>();

            // Process all nodes at this level
            for (int i = 0; i < n; i++) {

                TreeNode node = queue.remove();

                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (level.size() > 0) result.add(level);

        }
        return result;
    }
}
