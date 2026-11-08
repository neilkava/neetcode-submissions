class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int v, int[][] isConnected, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i = 0; i < isConnected[v].length; i++) {
            if (isConnected[v][i] == 1) {
                dfs(i, isConnected, visited);
            }
        }
    }
}