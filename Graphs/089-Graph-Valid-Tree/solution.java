import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {

        // Tree : Undirected and ACYCLIC

        // Create adjacency list
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            adjacencyList.putIfAbsent(edge[0], new HashSet<>());
            adjacencyList.putIfAbsent(edge[1], new HashSet<>());

            // Add both edge directions since undirected
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);

        }

        // Set used for cycle detection
        Set<Integer> visited = new HashSet<>();

        if (!dfs(visited, adjacencyList, 0, -1)) return false;

        return (visited.size() == n);
    }   

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> adjacencyList, int current, int parent) {
        
        // Cycle
        if (visited.contains(current)) return false;

        visited.add(current);

        Set<Integer> neighbors = adjacencyList.getOrDefault(current, new HashSet<>());

        for (int neighbor : neighbors) {
            if (parent == neighbor) continue;
            if (!dfs(visited, adjacencyList, neighbor, current)) return false;
        }
        return true;
    }
}