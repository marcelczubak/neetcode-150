import java.util.*;

class MedianFinder {

    // For left half
    PriorityQueue<Integer> maxHeap;
    // For right half
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.peek() != null && num < maxHeap.peek()) maxHeap.offer(num);
        else minHeap.offer(num);

        while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            
            if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
            else minHeap.offer(maxHeap.poll());
        
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek();
    }
}
