package tree.unionFind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import unionFind.EvaluateDivision;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class TestEvaluateDivision {

    @Test
    public void test() {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "c"},
                {"a", "e"}, {"a", "a"}, {"x", "x"}};

        EvaluateDivision ed = new EvaluateDivision();
        Arrays.stream(ed.calcEquation(equations, values, queries)).forEach(System.out::println);
    }
}
