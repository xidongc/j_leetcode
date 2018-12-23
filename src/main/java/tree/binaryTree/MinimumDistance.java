package tree.binaryTree;

public class MinimumDistance {

    private int min = Integer.MAX_VALUE;
    private int curr = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node){
        if (node == null) {
            return;
        }
        this.inOrder(node.left);
        min = Math.abs(node.val - curr);
        curr = node.val;
        this.inOrder(node.right);
    }
}
