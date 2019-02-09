package string;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> ret = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for (String word: words) {
            hash.put(word, hash.getOrDefault(word, 0) + 1);
        }

        // compare
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hash.entrySet());
        Collections.sort(list, new myComparator());

        // get result
        int tmp = k;

        for (Map.Entry<String, Integer> ele: list) {
            ret.add(ele.getKey());
            if (ret.size() == k){
                break;
            }
        }
        return ret;
    }

}

class myComparator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (!o2.getValue().equals(o1.getValue())){
            return o2.getValue().compareTo(o1.getValue());
        } else {
            return o1.getKey().compareTo(o2.getKey());
        }
    }
}
