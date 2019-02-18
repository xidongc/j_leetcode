package tree.binaryTree;

import java.util.*;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        // divide
        if (root == null) {
            return 0;
        }
        int ans = 0;

        if (root.left != null){
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }

        ans += sumOfLeftLeaves(root.right);
        return ans;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int ans = 0;
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            if (curr == null) {
                return ans;
            }
            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null) {
                    ans += curr.left.val;
                } else {
                    stack.push(curr.left);
                }
            }
            if (curr.right != null) {
                if (!(curr.right.left == null && curr.right.right == null)) {
                    stack.push(curr.right);
                }
            }
        }
        return ans;
    }

}
