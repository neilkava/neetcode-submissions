class Solution {
    public int countComponents(int n, int[][] edges) {
        int connectedComps = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] currentEdge = edges[i];
            adjList.get(currentEdge[0]).add(currentEdge[1]);
            adjList.get(currentEdge[1]).add(currentEdge[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComps++;
                dfs(i, adjList, visited);
            }
        }
        return connectedComps;
    }

    private void dfs(int i, List<List<Integer>> adjList, boolean[] visited) {
        visited[i] = true;
        for (int nghbr : adjList.get(i)) {
            if (!visited[nghbr]) {
                dfs(nghbr, adjList, visited);
            }
        }
        return;
    }
}
