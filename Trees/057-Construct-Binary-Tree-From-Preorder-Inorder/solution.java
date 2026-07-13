import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preorderIndex = 0;
        
        // preprocess inorder elements into a map for O(1) lookups
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        
        return helper(preorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode helper(int[] preorder, int left, int right, Map<Integer, Integer> map) {

        if (left > right) return null;

        int root = preorder[preorderIndex];
        preorderIndex++;
        
        // find root in inorder
        int rootIndex = map.get(root);

        // create this node
        TreeNode node = new TreeNode(root);

        // call helper on both subtrees to L and R of the root in inorder
        node.left = helper(preorder, left, rootIndex - 1, map);
        node.right = helper(preorder, rootIndex + 1, right, map);

        return node;
    }
}