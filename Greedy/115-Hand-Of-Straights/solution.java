import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        // Sort the cards in increasing order
        Arrays.sort(hand);
        
        // Accumulate frequencies in a hashmap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int card : hand) freqMap.put(card, freqMap.getOrDefault(card, 0)+1);
        
        // Iterate sorted cards
        for (int card : hand) {
            
            // Find lowest available card (be greedy)
            if (freqMap.get(card) == 0) continue;

            for (int i = card; i < card + groupSize; i++) {
                
                // No card available to form hand
                if (!freqMap.containsKey(i) || freqMap.get(i) == 0) return false;

                // Decrement count
                freqMap.put(i, freqMap.get(i) - 1);
            }
        }
        // All hands formed ... OK
        return true;
    }
}
