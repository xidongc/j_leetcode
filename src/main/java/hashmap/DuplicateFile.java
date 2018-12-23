package hashmap;

import java.util.*;

public class DuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        TreeMap<String, TreeSet<String>> fileRel = new TreeMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String p : paths) {
            String[] fh = p.split(" ");
            if (fh.length >= 2) {
                String base = fh[0];
                for (int i=1; i < fh.length; ++i) {
                    String[] tmp = fh[i].split("\\(");
                    String name = base.concat("/").concat(tmp[0]);
                    String val = fh[i].substring(
                            tmp[0].length(),
                            fh[i].length()-1);

                    if (fileRel.containsKey(val)) {
                        fileRel.get(val).add(name);
                    } else {
                        TreeSet<String> inner = new TreeSet<>();
                        inner.add(name);
                        fileRel.put(val, inner);
                    }
                }
            }
        }
        for (TreeSet<String> x: fileRel.values()) {
            List<String> tmp = new ArrayList<>(x);
            if (tmp.size() > 1) {
                result.add(tmp);
            }
        }
        return result;
    }
}
