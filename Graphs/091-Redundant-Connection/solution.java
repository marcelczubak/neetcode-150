// ----------------------------------------- Union Find Approach ------------------------------------------------
class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        // Create parent array
        parent = new int[edges.length+1];
        for (int i = 1; i < parent.length; i++) parent[i] = i;
        

        // Iterate all edges in order
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Unifying would cause a cycle ... return the edge
            if(!union(u,v)) return edge;
        }
        return new int[]{};
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // Can't unify ... already belong to same group (cycle creation)
        if (rootA == rootB) return false;

        // Otherwise ... unify
        parent[rootA] = rootB;
        return true;
    }
}

// -------------------------------------- Incremental DFS Approach ----------------------------------------------
// class Solution {
//     public int[] findRedundantConnection(int[][] edges) {
        
//         // Create adjacency list (graph)
//         Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
//         for (int[] edge : edges) {

//             int u = edge[0];
//             int v = edge[1];

//             Set<Integer> visited = new HashSet<>();

//             if (dfs(adjacencyList, visited, u, v)) {
//                 return edge;
//             } else {
//                 adjacencyList.putIfAbsent(u, new HashSet<>());
//                 adjacencyList.putIfAbsent(v, new HashSet<>());
//                 adjacencyList.get(u).add(v);
//                 adjacencyList.get(v).add(u);
//             }
//         }   
//         return new int[]{-1,-1};
//     }

//     // Returns true if path exists from u to v
//     private boolean dfs(Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited, int u, int v) {
        
//         if (u == v) return true;
//         if (visited.contains(u)) return false;

//         visited.add(u);

//         Set<Integer> neighbors = adjacencyList.getOrDefault(u, new HashSet<>());
//         for (int neighbor : neighbors) {
//             if (dfs(adjacencyList, visited, neighbor, v)) return true;
//         }
//         return false;
//     }
// }