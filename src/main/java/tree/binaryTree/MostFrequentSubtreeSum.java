package tree.binaryTree;

import java.util.*;

class RetValue {

    HashMap<Integer, Integer> sumDict;
    int sum;

    RetValue(HashMap<Integer, Integer> sumDict, int sum){
        this.sumDict = sumDict;
        this.sum = sum;
    }
}

class MyComparator implements Comparator<Map.Entry<Integer, Integer>>{

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> value = findSumDictInTree(root).sumDict;
        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(value.entrySet());
        Collections.sort(list, new MyComparator());
        ArrayList<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> l: list) {
            if (l.getValue() == list.get(0).getValue()) {
                ret.add(l.getKey());
            }
        }
        return ret.stream().mapToInt(x ->x.intValue()).toArray();
    }

    public RetValue findSumDictInTree(TreeNode root) {
        HashMap<Integer, Integer> sumDict = new HashMap<>();
        if (root == null) {
            return new RetValue(sumDict, 0);
        }

        RetValue leftRetValue = findSumDictInTree(root.left);
        RetValue rightRetValue = findSumDictInTree(root.right);
        HashMap<Integer, Integer> leftSumDict = leftRetValue.sumDict;
        HashMap<Integer, Integer> rightSumDict = rightRetValue.sumDict;
        sumDict.put(root.val+leftRetValue.sum+rightRetValue.sum,
                (sumDict.getOrDefault(root.val+leftRetValue.sum+rightRetValue.sum, 0)+1));
        for(Map.Entry<Integer, Integer> ele: leftSumDict.entrySet()) {
            sumDict.put(ele.getKey(), sumDict.getOrDefault(ele.getKey(), 0)+ele.getValue());
        }
        for(Map.Entry<Integer, Integer> ele2: rightSumDict.entrySet()) {
            sumDict.put(ele2.getKey(), sumDict.getOrDefault(ele2.getKey(), 0)+ele2.getValue());
        }
        return new RetValue(sumDict, root.val+leftRetValue.sum+rightRetValue.sum);
    }
}
