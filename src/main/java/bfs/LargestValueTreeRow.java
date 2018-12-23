package bfs;

import tree.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (q.size() > 0) {
            int len = q.size();
            int tmp = Integer.MIN_VALUE;
            for (int i=0; i<len; ++i) {
                TreeNode tmpNode = q.poll();
                if (tmpNode != null) {
                    tmp = Math.max(tmp, tmpNode.val);
                    if (tmpNode.left != null) {
                        q.offer(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        q.offer(tmpNode.right);
                    }
                }
            }

            result.add(tmp);
        }
        return result;
    }
}
