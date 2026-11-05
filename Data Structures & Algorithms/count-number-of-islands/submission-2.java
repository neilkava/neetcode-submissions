class Solution 
{
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) 
    {
        int islandCount = 0;
        
        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0; j < grid[0].length; j++) 
            {
                if (grid[i][j] == '1') 
                {
                    bfs(i, j, grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void bfs(int i, int j, char[][] grid) 
    {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';
        q.add(new int[]{i, j});
        
        while (!q.isEmpty())
        {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions)
            {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == '1')
                {
                    grid[nr][nc] = '0';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}