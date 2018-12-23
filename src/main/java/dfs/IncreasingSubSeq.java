package dfs;

import java.util.*;

public class IncreasingSubSeq {
    private Set<ArrayList<Integer>> result = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length <= 1) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        this.dfs(Integer.MIN_VALUE, 0, nums, stack);
        return new ArrayList<>(this.result);
    }

    private void dfs(int current, int currentIndex, int[] nums, Stack<Integer> stack) {
        if (stack.size() >= 2) {
            result.add(new ArrayList<>(stack));
        }
        if (currentIndex >= nums.length){
            return;
        }

        int j = 0;
        for (int x: Arrays.copyOfRange(nums, currentIndex, nums.length)) {
            j ++;
            if (x >= current) {
                stack.push(x);
                this.dfs(x, j+currentIndex, nums, stack);
                stack.pop();
            }
        }
    }
}
