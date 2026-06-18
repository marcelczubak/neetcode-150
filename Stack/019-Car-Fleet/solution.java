import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int N = position.length;

        // [position, arrivalTime]
        double[][] cars = new double[N][2];

        for (int i = 0; i < N; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }

        // Sort by car closest to target (position descending)
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        // A new fleet forms only if it takes longer than the fleet in front
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            double time = cars[i][1];

            // if this car cannot catch fleet in front -> new fleet
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
