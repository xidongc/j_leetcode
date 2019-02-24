package unionFind;

import java.util.HashMap;

class RetType {
    String name;
    double value;

    RetType(String name, double value) {
        this.name = name;
        this.value = value;
    }
}

public class EvaluateDivision {
    // child -> parent
    private HashMap<String, String> parent = new HashMap<>();

    // ele -> division ele*division
    private HashMap<String, Double> division = new HashMap<>();

    private String find(String child) {
        if (!parent.containsKey(child)) {
            parent.put(child, child);
            division.put(child, 1.0);
            return child;
        }
        return findHelper(child).name;
    }

    private RetType findHelper(String child) {
        if (parent.get(child).equals(child)) {
            return new RetType(child, 1);
        }
        RetType rt = findHelper(parent.get(child));
        parent.put(child, rt.name);
        double val = division.get(child) * rt.value;
        division.put(child, val);
        return new RetType(rt.name, val);
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i=0; i<equations.length; ++i) {
            String r1 = find(equations[i][0]);
            String r2 = find(equations[i][1]);
            parent.put(r2, r1);
            division.put(r2, division.get(equations[i][0]) / division.get(equations[i][1]) * values[i]);

        }

        double[] ret = new double[queries.length];


        for (int j=0; j<queries.length; ++j) {
            if (parent.containsKey(queries[j][1]) && parent.containsKey(queries[j][0])) {
                String parent1 = find(queries[j][1]);
                String parent2 = find(queries[j][0]);

                if (parent1.equals(parent2)) {
                    ret[j] = division.get(queries[j][1]) / division.get(queries[j][0]);
                } else {
                    ret[j] = -1.0;
                }
            } else {
                ret[j] = -1.0;
            }
        }

        return ret;
    }
}
