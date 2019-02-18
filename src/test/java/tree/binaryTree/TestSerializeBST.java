package tree.binaryTree;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tree.binarySearchTree.SerializeBST;

@RunWith(JUnit4.class)
public class TestSerializeBST {

    @Test
    public void test() {
        BinaryTreeCommon bstCommon = new BinaryTreeCommon();
        // int[] input = new int[]{1,2,3,4,5,6,7,8,9};
        int[] input = new int[] {};
        TreeNode root = bstCommon.createBSTfromArrays(input);
        bstCommon.printBSTwithInOrder(root);
        System.out.println(" ");
        bstCommon.printBSTwithPreOrder(root);

        System.out.println("Program start");
        SerializeBST sbst = new SerializeBST();
        String s = sbst.serialize(root);
        System.out.println(s);
        TreeNode root2 = sbst.deserialize(s);
        bstCommon.printBSTwithInOrder(root2);
        System.out.println("Program end");
    }

}
