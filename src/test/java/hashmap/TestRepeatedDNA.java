package hashmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public class TestRepeatedDNA {

    @Test
    public void test(){
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        ArrayList<String> output = new ArrayList<>();
        output.add("AAAAACCCCC");
        output.add("CCCCCAAAAA");
        testFindRepeatedDnaSequences(input, output);
    }

    public void testFindRepeatedDnaSequences(String input, ArrayList<String> output){
        RepeatedDNA rd = new RepeatedDNA();
        ArrayList<String> result = new ArrayList<>(rd.findRepeatedDnaSequences(input));
        assertThat(result).isEqualTo(output);
    }
}
