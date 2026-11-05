class Solution {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int area, maxIslandArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = dfs(i, j, grid);
                    maxIslandArea = area > maxIslandArea ? area : maxIslandArea;
                }
            }
        }

        return maxIslandArea;
    }

    private static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        grid[i][j] = 0;
        int area = 1;

        for (int[] dir: directions) {
            area += dfs(i + dir[0], j + dir[1], grid);
        }
    
        return area;
    }
}
