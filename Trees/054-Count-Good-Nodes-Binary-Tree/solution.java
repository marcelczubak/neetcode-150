
class Solution {

    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        
        dfs(root, root.val);
        return goodNodes;
    }

    private void dfs(TreeNode root, int maximum) {

        if (root == null) return;
        if (root.val >= maximum) goodNodes++;
    
        int newMax = Math.max(maximum, root.val);

        dfs(root.left, newMax);
        dfs(root.right, newMax);
    }
}