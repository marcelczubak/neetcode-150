import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        // Construct adjacency list
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            adjacencyList.putIfAbsent(prerequisite[0], new HashSet<>());
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
        }

        Set<Integer> visited = new HashSet<>();

        List<Integer> result = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, adjacencyList, visited, result)) return new int[]{};
        }

        int[] resultArray = new int[numCourses];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    private boolean dfs(int course, Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited, List<Integer> result) {
        if (visited.contains(course)) return false;

        if (adjacencyList.get(course) != null && adjacencyList.get(course).isEmpty()) return true;

        visited.add(course);

        Set<Integer> neighbors = adjacencyList.getOrDefault(course, new HashSet<>());
        for (Integer neighbor : neighbors) {
            if (!dfs(neighbor, adjacencyList, visited, result)) return false;

        }

        visited.remove(course);
        adjacencyList.put(course, new HashSet<>());

        result.add(course);
        
        return true;
    }
}

