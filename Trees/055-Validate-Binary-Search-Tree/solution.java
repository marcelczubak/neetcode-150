class Solution {

    public boolean isValidBST(TreeNode root) {

        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int min, int max) {

        if (root == null) return true;

        // Out of bounds
        if (root.val <= min || root.val >= max) return false;

        // Within bounds
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}