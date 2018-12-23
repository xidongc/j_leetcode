package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.Node;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i=0; i<size; ++i) {
                Node n = q.poll();
                tmp.add(n.val);
                for (Node c: n.children){
                    q.offer(c);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
