class Solution {
    public double myPow(double x, int n) {
        
        if (x == 0) return 0;
        if (n == 0) return 1;

        boolean neg = (n < 0);

        n = Math.abs(n);

        // Compute (x ^ (n/2))
        double halfPow = myPow(x, n/2);

        double squared = halfPow * halfPow;

        if (n%2 != 0) squared *= x;

        return (neg) ? 1/squared : squared;

    }
}
