package tree.binarySearchTree;

import tree.binaryTree.TreeNode;
import java.util.*;

public class SerializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        String currString = root.val + ",";
        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        return currString + leftString + rightString;
    }

    // Decodes your encoded data to tree.
    //[1,2,3,4,5,6,7,8,9]
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        int[] inOrder = Arrays.stream(data.split(",")).map(Integer::valueOf).mapToInt(x->x.intValue()).toArray();
        int[] preOrder = new int[inOrder.length];
        System.arraycopy(inOrder, 0, preOrder, 0, inOrder.length);
        Arrays.sort(inOrder);

        // create tree from inOrder and preOrder
        return createBSTfromTraversal(inOrder, preOrder);
    }

    private TreeNode createBSTfromTraversal(int[] inOrder, int[] preOrder) {
        if (inOrder.length == 1) {
            return new TreeNode(inOrder[0]);
        } else if (inOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[0]);
        int index = 0;
        while (inOrder[index] != preOrder[0]) {
            index ++;
        }
        root.left = createBSTfromTraversal(Arrays.copyOfRange(inOrder,0,index), Arrays.copyOfRange(preOrder,1, index+1));
        root.right = createBSTfromTraversal(Arrays.copyOfRange(inOrder, index+1, inOrder.length), Arrays.copyOfRange(preOrder, index+1, preOrder.length));
        return root;
    }

}
