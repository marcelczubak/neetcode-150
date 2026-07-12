class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // If p and q are in different subtrees ... current node is the LCA
        if ((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) return root;

        // If p and q are both in the same subtree ... go deeper to that subtree
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        
        // Else this is the LCA
        return root;
    }
}