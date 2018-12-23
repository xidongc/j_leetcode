package bfs;

public class MineSweeper {

    // notice deepcopy
    public char[][] updateBoard(char[][] board, int[] click) {
        char [][] result = new char[board.length][board[0].length];
        if (click.length != 2){
            return result;
        }
        if (board[click[0]][click[1]] == 'M'){
            result = board;
            result[click[0]][click[1]] = 'X';
            return result;
        }

        class InnerClass{
            private char[][] result = board;
            private int[] deltaX = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            private int[] deltaY = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
            private boolean[][] flag = new boolean[board.length][board[0].length];

            private void dfs(int[] current){
                this.flag[current[0]][current[1]] = true;
                if (board[current[0]][current[1]] == 'M'){
                    return;
                }
                if (this.hasAdjM(current) != 0){
                    this.result[current[0]][current[1]] = (char)(this.hasAdjM(current)+48);
                    return;
                }
                this.result[current[0]][current[1]] = 'B';
                for (int i=0; i<deltaX.length; ++i){
                    if ((current[0]+deltaX[i] >=0) &&
                            (current[1]+deltaY[i] >= 0)&&
                            (current[0]+deltaX[i] < board.length) &&
                            (current[1]+deltaY[i] < board[0].length) &&
                            (! this.flag[current[0]+deltaX[i]][current[1]+deltaY[i]]) &&
                            (board[current[0]+deltaX[i]][current[1]+deltaY[i]] != 'M')) {
                        int[] newCurrent = new int[]{current[0]+deltaX[i], current[1]+deltaY[i]};
                        this.dfs(newCurrent);
                    }
                }
            }

            private int hasAdjM(int[] current){
                int count = 0;
                for (int i=0; i<deltaX.length; ++i){
                    if ((current[0]+deltaX[i] >=0) &&
                            (current[1]+deltaY[i] >= 0)&&
                            (current[0]+deltaX[i] < board.length) &&
                            (current[1]+deltaY[i] < board[0].length) &&
                            (board[current[0]+deltaX[i]][current[1]+deltaY[i]] == 'M')){
                        count ++;
                    }
                }
                return count;
            }
        }

        InnerClass inn = new InnerClass();
        inn.dfs(click);
        return inn.result;
    }
}
