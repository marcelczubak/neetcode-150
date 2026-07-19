class Solution {
    public int climbStairs(int n) {
        
        // FIBONACCI
        // n = 1 ... 1
        // n = 2 ... 2
        // n = 3 ... 3
        // n = 4 ... 5
        // n = 5 ... 8
        // n = 6 ... 13
        
        int a = 1;
        int b = 1;

        for(int i = 0; i < n-1; i++) {
            int temp = a;
            a = a+b;
            b = temp;
        }
        return a;
    }
}
