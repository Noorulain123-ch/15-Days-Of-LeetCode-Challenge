import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    // Recursive helper function
    void inorder(TreeNode node, List<Integer> list) {
        if (node == null) 
            return;

        inorder(node.left, list);    // 1. Left
        list.add(node.val);          // 2. Root
        inorder(node.right, list);   // 3. Right
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.inorderTraversal(root)); 
        // Output: [1, 3, 2]
    }
}
