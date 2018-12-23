package bfs;//200 number of islands
import java.util.*;
public class Numoi {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null){
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<Character> queue = new LinkedList<>();
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    bfs(grid,dx,dy,i,j);
                    res ++;
                }
            }
        }

        return res;
    }
    private void bfs(char[][] grid, int[] dx, int[] dy, int x, int y){
        grid[x][y] = '0';
        for(int a = 0; a < 4; a ++){
            int newx = x + dx[a];
            int newy = y + dy[a];
            if(newx >= 0 && newy >=0 && newx < grid.length && newy < grid[0].length && grid[newx][newy] == '1'){
                bfs(grid,dx,dy,newx,newy);
            }
        }
    }
}
