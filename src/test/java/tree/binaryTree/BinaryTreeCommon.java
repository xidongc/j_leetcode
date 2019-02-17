package tree.binaryTree;

import apple.laf.JRSUIUtils;

import java.util.*;

public class BinaryTreeCommon {

    TreeNode createBSTfromArrays(int[] input) {
        if (input.length == 1) {
            return new TreeNode(input[0]);
        } else if (input.length == 0) {
            return null;
        }
        Arrays.sort(input);
        int mid = input.length / 2;
        TreeNode root = new TreeNode(input[mid]);
        root.left = createBSTfromArrays(Arrays.copyOfRange(input, 0, mid));
        root.right = createBSTfromArrays(Arrays.copyOfRange(input, mid+1, input.length));
        return root;
    }

    void printBSTwithInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printBSTwithInOrder(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        printBSTwithInOrder(root.right);
    }

    void printBSTwithPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        System.out.print(" ");
        printBSTwithInOrder(root.left);
        printBSTwithInOrder(root.right);
    }



}
