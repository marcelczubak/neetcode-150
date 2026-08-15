import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        // Construct adjacency list
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new ArrayList<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        // Sort the neighbors list of every airport (to ensure lexicographical order)
        for (String airport : graph.keySet()) {

            List<String> neighbors = graph.get(airport);

            Collections.sort(neighbors);   // OR... neighbors.sort((a,b) -> a.compareTo(b))
        }

        List<String> itinerary = new ArrayList<>();

        dfs(graph, itinerary, "JFK");

        Collections.reverse(itinerary);

        return itinerary;
    }

    private void dfs(Map<String, List<String>> graph, List<String> itinerary, String airport) {

        List<String> neighbors = graph.get(airport);  

        if (neighbors == null) {
            itinerary.add(airport);
            return;
        }

        while(!neighbors.isEmpty()) {
            String neighbor = neighbors.remove(0);
            dfs(graph, itinerary, neighbor);
        }
        itinerary.add(airport);
    }
}