package bfs;//305 number of islands ||

import java.util.*;
public class Numoi2 {
    int[][] dirctions = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions){
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0){
            return result;
        }
        int count = 0;
        int[] roots = new int[m*n];
        Arrays.fill(roots,-1);
        for(int[] position : positions){
            int root = position[0]*n + position[1];  // assume new point is isolated island
            roots[root] = root; // add new island
            count ++;
            for(int[] direction:dirctions){
                int x = direction[0] + position[0];
                int y = direction[1] + position[1];
                int newroot = x * n + y;
                if(x >= 0 && y >= 0 && x < m && y < n && roots[newroot] != -1){
                    int a = findIsland(roots, newroot);
                    if(a != root){
                        roots[root] = a; // if neighbor is in another island
                        root = a;   // union two islands,(to existing root?)
                        count --;   // current tree root = joined tree root
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    private int findIsland(int[] roots, int root){
//        不会出现roots[root] == -1情况
        while(roots[root] != root){
//            roots[root] = roots[roots[root]];   // only one line added
//            root = roots[root];
            root = roots[root];
        }
        return roots[root];
    }
    public static void main(String[] args){
        Numoi2 n = new Numoi2();
        int[][] positions = {{0,1},{1,0},{1,1},{2,1}};
        n.numIslands2(3,3, positions);
    }
}

