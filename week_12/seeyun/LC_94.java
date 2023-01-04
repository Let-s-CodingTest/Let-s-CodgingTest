package seeyun;

import java.util.ArrayList;
import java.util.List;

public class LC_94 { // Binary Tree Inorder Traversal
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            recur(root, res);
            return res;
        }

        public void recur(TreeNode root, List<Integer> res) {
            if (root != null) {
                recur(root.left, res);
                res.add(root.val);
                recur(root.right, res);
            }
        }

    }
}
