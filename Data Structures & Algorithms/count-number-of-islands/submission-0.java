class Solution {
    char[][] searchGrid;
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // '0' means unexplored territory
        // '1' means explored territory which is land
        searchGrid = new char[rows][cols];
        for (char[] row : searchGrid) {
            for (int i = 0; i < row.length; i++) {
                row[i] = '0';
            }
        }

        int islandCount = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && searchGrid[i][j] == '0') {
                    islandCount++;
                    searchGrid[i][j] = '1';
                    exploreNeighbouringTerritory(i, j, grid);
                }
            }
        }

        return islandCount;
    }

    private void exploreNeighbouringTerritory(int i, int j, char[][] grid) {
        if (i > 0 && grid[i - 1][j] == '1' && searchGrid[i - 1][j] == '0') {
            searchGrid[i - 1][j] = '1';
            exploreNeighbouringTerritory(i - 1, j, grid);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1' && searchGrid[i + 1][j] == '0') {
            searchGrid[i + 1][j] = '1';
            exploreNeighbouringTerritory(i + 1, j, grid);
        }
        if (j > 0 && grid[i][j - 1] == '1' && searchGrid[i][j - 1] == '0') {
            searchGrid[i][j - 1] = '1';
            exploreNeighbouringTerritory(i, j - 1, grid);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1' && searchGrid[i][j + 1] == '0') {
            searchGrid[i][j + 1] = '1';
            exploreNeighbouringTerritory(i, j + 1, grid);
        }
    }
}