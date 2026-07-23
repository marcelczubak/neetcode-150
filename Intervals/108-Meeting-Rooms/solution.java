import java.util.*;

class Solution {
    
    class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort meetings based on starting time
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // Iterate sorted array
        //  If any ending time runs into the next start time, return false
        for (int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start < intervals.get(i-1).end) return false;
        }

        return true;
    }
}
