import java.util.*;

class CountSquares {

    // <point, frequency>
    Map<String, Integer> points;

    // Custom method to convert points to String keys
    private String pointToKey(int x, int y) {
        return x + "," + y;
    }

    public CountSquares() {
        points = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.put(pointToKey(point[0], point[1]), points.getOrDefault(pointToKey(point[0], point[1]), 0)+1);
    }
    
    public int count(int[] point) {  
        int squares = 0;

        for (String diagPoint : points.keySet()) {

            String[] parts = diagPoint.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            int xDiff = Math.abs(point[0] - x);
            int yDiff = Math.abs(point[1] - y);

            if (xDiff == yDiff && xDiff != 0) {
                
                String topLeft = pointToKey(point[0], y);
                String bottomRight = pointToKey(x, point[1]);

                if (points.containsKey(topLeft) && points.containsKey(bottomRight)) {
                    squares += (points.get(topLeft) * points.get(bottomRight) * points.get(diagPoint));
                }
            }
        }
        return squares;
    }
}
