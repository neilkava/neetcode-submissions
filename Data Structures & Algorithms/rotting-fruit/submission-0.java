class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0, fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        // currently, we have all rotten bananas enqueued
        // next step is to poll each rotten banana
        // for each poll, we explore 1 level of neighbours
        // we enqueue every ripe banana found and update its value to '2' (rotten)
        // each time, we explore 1 level, we increment minutes counter by 1
        // after we're done exploring, we check if grid has any '1' if yes return -1
        // else, we return 'minutes'

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            while (size >= 1) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0) {
                        continue;
                    }
                    if (grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r, c});
                    }
                }
                size--;
            }
            minutes++;
        }

        if (fresh > 0) {
            return -1;
        }
        
        return minutes;
    }
}
