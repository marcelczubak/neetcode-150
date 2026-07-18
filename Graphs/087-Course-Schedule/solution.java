import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Construct adjacency list
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adjacencyList.putIfAbsent(prerequisite[0], new HashSet<>());
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjacencyList, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited) {
        if (visited.contains(course)) return false;

        if (adjacencyList.get(course) != null && adjacencyList.get(course).isEmpty()) return true;

        visited.add(course);

        Set<Integer> neighbors = adjacencyList.getOrDefault(course, new HashSet<>());
        for (Integer neighbor : neighbors) {
            if (!dfs(neighbor, adjacencyList, visited)) return false;

        }

        visited.remove(course);
        adjacencyList.put(course, new HashSet<>());
        
        return true;
    }


}
