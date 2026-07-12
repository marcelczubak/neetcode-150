import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();

        bfs(root, result);

        return result;
    }

    private void bfs(TreeNode root, List<Integer> result) {
 
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.remove();

                // Add last node in the level to the result list
                if (i + 1 == levelSize) result.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null)  queue.add(node.right);
            }
        }
    }
}