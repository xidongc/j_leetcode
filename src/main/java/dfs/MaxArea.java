package dfs;

public class MaxArea {

    // Sol-1 internal class dfs (use global count, to get nodes count in a tree)

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 && grid[0].length == 0){
            return 0;
        }
        boolean[][] isLand = new boolean[grid.length][grid[0].length];

        class InnerClass {
            private int maxValue = 0;
            private int count = 0;
            private int[] deltaX = new int[]{1, 0, 0, -1};
            private int[] deltaY = new int[]{0, 1, -1, 0};

            private void dfs(int i, int j, int[][]grid, boolean[][] flag){
                flag[i][j] = true;
                this.count ++;

                for (int k=0; k<deltaX.length; ++k) {
                    if ((i+deltaX[k])>=0 && (i+deltaX[k] < grid.length) &&
                            (j+deltaY[k] >=0) && (j+deltaY[k] < grid[0].length) &&
                            (grid[i+deltaX[k]][j+deltaY[k]] == 1) &&
                            (!flag[i+deltaX[k]][j+deltaY[k]])){
                        this.dfs(i+deltaX[k], j+deltaY[k], grid, flag);
                    }
                }
                this.maxValue = Math.max(this.maxValue, this.count);
            }
        }

        InnerClass inn = new InnerClass();
        for (int i=0; i<grid.length; ++i) {
            for (int j=0; j<grid[0].length; ++j) {
                if (grid[i][j] == 1 && !isLand[i][j]){
                    inn.dfs(i, j, grid, isLand);
                    inn.count = 0;
                }
            }
        }
        return inn.maxValue;
    }
}
