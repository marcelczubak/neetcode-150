import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int NUM_WINDOWS = nums.length - k + 1;
        int[] output = new int[NUM_WINDOWS];
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(0);

        // Build first window
        for (int i = 1; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // The maximum for the first window is the head of the deque
        output[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            
            // Remove redundant indices
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Update new maximum
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // Populate output array
            output[i - k + 1] = nums[deque.peekFirst()];
        }

        return output;
    }
}
