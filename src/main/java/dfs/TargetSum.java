package dfs;

public class TargetSum {
    static int[] symbol = new int[]{1, -1};
    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        this.dfs(nums, 0, S);
        return this.count;
    }

    private void dfs(int[] nums, int level, int target) {
        if (target == 0 && level == nums.length) {
            count ++;
            return;
        } else if (level == nums.length){
            return;
        }

        for (int s: symbol) {
            if (level < nums.length && level >= 0) {
                this.dfs(nums, level + 1, target-s * nums[level]);
            }
        }
    }
}
