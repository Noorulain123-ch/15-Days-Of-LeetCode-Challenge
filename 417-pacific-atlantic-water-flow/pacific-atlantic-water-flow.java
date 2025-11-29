import java.util.*;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        // DFS from Pacific borders
        for (int i = 0; i < m; i++) dfs(heights, pac, i, 0);       // left edge
        for (int j = 0; j < n; j++) dfs(heights, pac, 0, j);       // top edge

        // DFS from Atlantic borders
        for (int i = 0; i < m; i++) dfs(heights, atl, i, n - 1);   // right edge
        for (int j = 0; j < n; j++) dfs(heights, atl, m - 1, j);   // bottom edge

        List<List<Integer>> ans = new ArrayList<>();

        // Add cells that reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    // Simple DFS
    void dfs(int[][] h, boolean[][] visited, int r, int c) {
        int m = h.length;
        int n = h[0].length;

        // Already visited
        if (visited[r][c]) return;

        visited[r][c] = true;

        // Directions → up, down, left, right
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            // Check bounds
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

            // Water can only go from low to high → so reverse flow condition:
            if (h[nr][nc] >= h[r][c]) {
                dfs(h, visited, nr, nc);
            }
        }
    }
}
