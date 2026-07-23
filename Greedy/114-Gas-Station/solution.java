class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        // Insufficient gas
        int gasSum = 0, costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (costSum > gasSum) return -1;


        // Track gas balance
        int currentTank = 0;

        // Index from which a complete circuit is possible
        int candidateStart = 0;
      
        for (int i = 0; i < gas.length; i++) {

            currentTank += (gas[i] - cost[i]);

            if (currentTank < 0) {
                // candidateStart ... i are all impossible starting locations
                candidateStart = i+1;
                currentTank = 0;
            }
        }
        return candidateStart;
    }
}
