package tree.binaryTree;

import apple.laf.JRSUIUtils;

import java.util.*;

public class AllNodesDistanceK {

    private HashMap<TreeNode, TreeNode> father = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        createParentNode(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        int level = 0;
        List<Integer> levelTraversal = new ArrayList<>();
        queue.offer(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            int l = queue.size();
            if (level == K) {
                for (TreeNode n: queue) {
                    levelTraversal.add(n.val);
                }
            }
            for (int i=0; i<l; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    // parent, left, right
                    if (!visited.contains(curr.left) && curr.left != null) {
                        queue.offer(curr.left);
                        visited.add(curr.left);
                    }

                    if (!visited.contains(curr.right) && curr.right != null) {
                        queue.offer(curr.right);
                        visited.add(curr.right);
                    }

                    if (!visited.contains(father.get(curr)) && father.get(curr) != null) {
                        queue.offer(father.get(curr));
                        visited.add(father.get(curr));
                    }
                }
            }
            level ++;
        }
        return levelTraversal;
    }

    public void createParentNode(TreeNode root, TreeNode par) {
        if (root != null) {
            father.put(root, par);
            createParentNode(root.left, root);
            createParentNode(root.right, root);
        }
    }

}
