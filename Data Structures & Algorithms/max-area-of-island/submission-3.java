class Solution {
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int area, maxIslandArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = bfs(i, j, grid);
                    maxIslandArea = area > maxIslandArea ? area : maxIslandArea;
                }
            }
        }

        return maxIslandArea;
    }

    private static int bfs(int i, int j, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = 0;
        int area = 1;
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] ele = q.poll();
            int row = ele[0], col = ele[1];
            for (int[] dir: directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] == 0) {
                    continue;
                }
                grid[nr][nc] = 0;
                area += 1;
                q.add(new int[]{nr, nc});
            }
        }

        return area;
    }
}
