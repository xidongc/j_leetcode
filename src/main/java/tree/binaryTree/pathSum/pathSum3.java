package tree.binaryTree.pathSum;

import tree.binaryTree.TreeNode;
import java.util.*;

public class pathSum3 {

    public int pathSum(TreeNode root, int sum) {
        ArrayList<Integer> stack = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        class InnerClass {
            private int found = 0;

            private void helper(TreeNode root, ArrayList<Integer> stack, int sum) {
                if (sum == 0) {
                    this.found ++;
                }
                if (root.right != null) {
                    stack.add(root.right.val);
                    helper(root.right, stack, sum-root.right.val);
                    stack.remove(stack.size() - 1);
                }
                if (root.left != null) {
                    stack.add(root.left.val);
                    helper(root.left, stack, sum-root.left.val);
                    stack.remove(stack.size() - 1);
                }
            }

            public void helper2(TreeNode root) {
                if (root == null) {
                    return;
                }
                stack.add(root.val);
                helper(root, stack, sum-root.val);
                helper2(root.left);
                helper2(root.right);

            }
        }
        InnerClass inn = new InnerClass();
        inn.helper2(root);
        return inn.found;
    }

}
