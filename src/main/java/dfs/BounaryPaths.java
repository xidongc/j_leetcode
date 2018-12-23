package dfs;

public class BounaryPaths {private int mod = 1000000000 + 7;

    // LTE, DFS with brute force

    public int findPaths(int m, int n, int N, int i, int j) {
        if (m <= 0 || n <= 0 || N <= 0){
            return 0;
        } else if (m == 1 && n == 1) {
            return 4;
        }
        long [][][] memo = new long[m][n][N+1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int kk = 0; kk < N+1; kk++) {
                    memo[ii][jj][kk] = -1;
                }
            }
        }

        class InnerClass {
            private int numbers = 0;
            private int[] deltaX = new int[]{1, 0, 0, -1};
            private int[] deltaY = new int[]{0, 1, -1, 0};

            private void dfs(int m, int n, int N, int i, int j, int count) {
                if (memo[i][j][count] == -1) {
                    memo[i][j][count] = this.numbers;
                } else {
                    this.numbers += memo[i][j][count];
                    return;
                }
                if (count >= N) {
                    return;
                }
                if ((i==0 || i==m-1) && (j==0 || j == n-1)){
                    this.numbers ++;
                }
                if (i==0 || i==m-1 || j==0 || j == n-1){
                    if (m == 1 || n == 1){
                        this.numbers ++;
                    }
                    this.numbers ++;
                }

                for (int k=0; k<deltaX.length; ++k) {
                    if ((i+deltaX[k]) >=0 && (i+deltaX[k]) < m &&
                            (j+deltaY[k]) >=0 && (j+deltaY[k]) < n){
                        this.dfs(m, n, N, i+deltaX[k], j+deltaY[k], count+1);
                    }
                }
            }
        }
        InnerClass inn = new InnerClass();
        inn.dfs(m, n, N, i, j, 0);
        return inn.numbers % this.mod;
    }
}
