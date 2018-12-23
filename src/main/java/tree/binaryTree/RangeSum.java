package tree.binaryTree;

public class RangeSum {

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.helper(root, L, R);
        return sum;
    }

    private void helper(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }
        this.helper(root.left, L, R);
        if (L <= root.val && root.val <= R) {
            this.sum  += root.val;
        }
        this.helper(root.right, L, R);
    }
}


//Closure, inner class implementation
class RangeSum2 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        final int sum = 0;

        class InnerClass {
            private int s = sum;
            public void helper(TreeNode root){
                if (root == null) {
                    return;
                }
                this.helper(root.left);
                if (L <= root.val && root.val <= R) {
                    s += root.val;
                }
                this.helper(root.right);
            }
        }
        InnerClass a = new InnerClass();
        a.helper(root);
        return a.s;
    }
}
