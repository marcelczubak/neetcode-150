class Solution {
    public int reverse(int x) {
        
        int result = 0;

        while (x != 0) {

            // Extract last digit
            int digit = x % 10;

            if (overflow(result, digit)) return 0;

            // Construct reversed result
            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }  

    private boolean overflow(int result, int digit) {

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        
        return (result > MAX/10 || 
                (result == MAX/10 && digit > 7) ||
                (result < MIN/10) ||
                (result == MIN/10 && digit < -8));
    }

}