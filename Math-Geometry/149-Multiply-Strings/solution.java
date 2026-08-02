class Solution {
    public String multiply(String num1, String num2) {
        
        int[] result = new int[num1.length() + num2.length()];

        // for every digit in num1 (R to L)
        for (int i = num1.length() - 1; i >= 0; i--) {

            int digit1 = num1.charAt(i) - '0';
        
            // for every digit in num2 (R to L)
            for (int j = num2.length() - 1; j >= 0; j--) {

                int digit2 = num2.charAt(j) - '0';

                // Multiply digits
                int product = digit1 * digit2;

                // Add existing value already stored
                product += result[i + j + 1];

                // Compute carry
                int carry = product / 10;

                // Store ones digit
                result[i + j + 1] = product % 10;

                // Add carry to previous position   
                result[i + j] += carry;

            }
        }

        // Convert array into string and skip leading zeroes
        StringBuilder ans = new StringBuilder();
        boolean leadingZeroFinish = false;
        for (int num : result) {
            if (num != 0) leadingZeroFinish = true;
            if (leadingZeroFinish) ans.append(num);
        }

        return (ans.length() == 0) ? "0" : ans.toString();
    }
}
