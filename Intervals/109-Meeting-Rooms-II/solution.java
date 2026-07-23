import java.util.*;

class Solution {

    class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        
        // Sort intervals based on starting times
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));

        // Min-Heap keeps track of first available room
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (Interval interval : intervals) {

            if (rooms.isEmpty()) {
                rooms.add(interval.end);
                continue;
            }

            if (rooms.peek() <= interval.start) rooms.poll();
            
            rooms.add(interval.end);
        }
        return rooms.size();
    }
}
