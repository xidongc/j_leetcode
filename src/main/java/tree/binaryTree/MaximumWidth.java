package tree.binaryTree;

import java.util.*;

class AnnotatedNode {
    TreeNode node;
    int position;

    AnnotatedNode(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

public class MaximumWidth {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0));
        int length = 0;
        if (root == null) {
            return length;
        }

        while (!queue.isEmpty()) {
            int l = queue.size();
            int left = -1;
            for (int i=0; i<l; ++i) {
                AnnotatedNode curr = queue.poll();
                if (curr.node != null) {
                    queue.offer(new AnnotatedNode(curr.node.left, 2*curr.position));
                    queue.offer(new AnnotatedNode(curr.node.right, 2*curr.position+1));
                    if (left == -1) {
                        left = curr.position;
                    }
                    length = Math.max(length, curr.position - left + 1);
                }
            }
        }
        return length;
    }

}
