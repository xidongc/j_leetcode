package tree;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeight {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> tmp = new ArrayList<>();

        for (Node c: root.children) {
            tmp.add(this.maxDepth(c));
        }
        if (tmp.size() > 0){
            return 1 + Collections.max(tmp);
        } else {
            return 1;
        }
    }
}
