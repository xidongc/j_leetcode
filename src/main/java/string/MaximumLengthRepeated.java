package string;

import java.util.*;

public class MaximumLengthRepeated {
    public int findLength(int[] A, int[] B) {
        // corner case
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int maxNumber = 0;

        HashMap<Integer, ArrayList<Integer>> count = new HashMap<>();
        for (int i=0; i<A.length; ++i) {
            ArrayList<Integer> tmpResult = count.getOrDefault(A[i], new ArrayList<>());
            tmpResult.add(i);
            count.put(A[i], tmpResult);
        }

        for (int j=0; j<B.length; ++j) {
            ArrayList<Integer> tmpResult = count.getOrDefault(B[j], new ArrayList<>());
            for (int index: tmpResult) {
                int k = 1;
                while (j+k < B.length &&
                        index+k < A.length &&
                        B[j+k] == A[index+k]) {
                    k += 1;
                }
                maxNumber = Math.max(maxNumber, k);
            }
        }

        return maxNumber;
    }
}
