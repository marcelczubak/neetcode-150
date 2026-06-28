class Solution {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return isBalanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1) isBalanced = false;

        return Math.max(left, right) + 1;

    }
}