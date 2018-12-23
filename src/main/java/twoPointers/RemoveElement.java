package twoPointers;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return 0;
        }

        while (left < right) {
            if (nums[left] == val) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right --;
            } else {
                left ++;
            }
        }
        if (nums[left] == val){
            return left;
        } else {
            return left+1;
        }
    }
}
