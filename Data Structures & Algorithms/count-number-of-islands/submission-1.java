class Solution 
{
    public int numIslands(char[][] grid) 
    {
        int islandCount = 0;
        
        for (int i = 0; i < grid.length; i++) 
        {
            for (int j = 0; j < grid[0].length; j++) 
            {
                if (grid[i][j] == '1') 
                {
                    exploreNeighbouringTerritory(i, j, grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void exploreNeighbouringTerritory(int i, int j, char[][] grid) 
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
        {
            return;
        }

        grid[i][j] = '0';

        exploreNeighbouringTerritory(i - 1, j, grid);
        exploreNeighbouringTerritory(i + 1, j, grid);
        exploreNeighbouringTerritory(i, j - 1, grid);
        exploreNeighbouringTerritory(i, j + 1, grid);
    }
}