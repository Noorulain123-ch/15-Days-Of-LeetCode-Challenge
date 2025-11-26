class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
