class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean foundA = false, foundB = false, foundC = false;

        for (int i = 0; i < triplets.length; i++) {

            int[] triplet = triplets[i];

            // Ignore any triplets whose values exceed corresponding target values
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            
            if (triplet[0] == target[0]) foundA = true;
            if (triplet[1] == target[1]) foundB = true;
            if (triplet[2] == target[2]) foundC = true;

            if (foundA && foundB && foundC) return true;
        }

        return (foundA && foundB && foundC);
    }
}
