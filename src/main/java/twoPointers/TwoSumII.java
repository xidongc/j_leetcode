package twoPointers;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result;
        while (left < right) {
            int cmp = numbers[left] + numbers[right];
            if (cmp > target) {
                right --;
            } else if (cmp == target) {
                result = new int[]{left+1, right+1};
                return result;
            } else {
                left ++;
            }
        }
        return new int[]{};
    }
}