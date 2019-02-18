package tree.binaryTree;

import java.util.*;

public class ConstructStringFromBT {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String leftString = tree2str(t.left);
        String rightString = tree2str(t.right);
        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        } else if (t.left == null) {
            return t.val+"()("+rightString + ")";
        }  else if (t.right == null) {
            return t.val+"("+leftString+")";
        }
        return t.val+"("+leftString+")"+"("+rightString+")";
    }
}
