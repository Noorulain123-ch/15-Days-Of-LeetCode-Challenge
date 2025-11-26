class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int v) {
        val = v;
    }
}

class Solution {

    int diameter = 0;  // will store the answer

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // function to get height of a node
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        // update diameter: longest path through this node
        diameter = Math.max(diameter, left + right);

        // return height of this node
        return Math.max(left, right) + 1;
    }
}
