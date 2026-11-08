class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        Queue<Integer> bfs = new LinkedList<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                bfs.offer(i);
                visited[i] = true;
                while (!bfs.isEmpty()) {
                    int v = bfs.poll();
                    for (int m = 0; m < isConnected[v].length; m++) {
                        if (isConnected[v][m] == 1 && !visited[m]) {
                            bfs.offer(m);
                            visited[v] = true;
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }
}