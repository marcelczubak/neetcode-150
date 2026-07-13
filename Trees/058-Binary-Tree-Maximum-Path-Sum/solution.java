class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    int maxPathSum = 0;

    public int maxPathSum(TreeNode root) {
        maxPathSum = root.val;
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        maxPathSum = Math.max(maxPathSum, leftMax + root.val + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}