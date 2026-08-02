import java.util.*;

class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sumSquareDigits(n);
        }

        return n == 1;
    }

    public int sumSquareDigits(int n) {
        int result = 0;
        int current = n;
        int number = n;
        int rem = 0;

        while(number >= 10) {
            current = Math.floorDiv(number, 10); 
            rem = number - 10*current;             
            number = current;                      
            result += (rem)*(rem);
        }

        // number < 10
        result += (number) * (number);
        System.out.println(result);
        return result;
    }

}
