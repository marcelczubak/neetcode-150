# Insert Interval

## Problem

You are given a list of **non-overlapping intervals** sorted in ascending order by their start times.

Insert a new interval into the list such that:

- The intervals remain sorted.
- Any overlapping intervals are merged.

Return the resulting list of intervals.

---

## Example 1

### Input

```text
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

### Output

```text
[[1,5],[6,9]]
```

---

## Example 2

### Input

```text
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
```

### Output

```text
[[1,2],[3,10],[12,16]]
```

---

# Key Observation

Since the intervals are **already sorted** and **non-overlapping**, every interval falls into one of three categories relative to the new interval.

```
            newInterval
                 |
                 v

 BEFORE      OVERLAP      AFTER
```

There is no need for nested loops or comparing neighbouring intervals.

---

# Approach

Iterate through the intervals once.

For every interval:

### Case 1 — Current interval is before the new interval

```
currentEnd < newStart
```

Example:

```text
current      [1,2]

new               [5,7]
```

No overlap.

Simply add the current interval.

---

### Case 2 — Current interval is after the new interval

```
currentStart > newEnd
```

Example:

```text
new          [2,4]

current             [6,8]
```

No overlap.

At this point:

- Add the merged new interval.
- Add every remaining interval.
- Stop.

---

### Case 3 — Overlap

Otherwise, the intervals overlap.

Merge them by expanding the new interval.

```
newStart = min(newStart, currentStart)

newEnd = max(newEnd, currentEnd)
```

Instead of creating a new interval every time, update `newInterval` directly.

---

# Algorithm

1. Create an output list.
2. Iterate through every interval.
3. If interval is before new interval:
   - Add interval.
4. Else if interval is after:
   - Add merged new interval.
   - Add remaining intervals.
   - Finish.
5. Otherwise:
   - Merge into `newInterval`.
6. If new interval was never inserted:
   - Add it at the end.
7. Convert the list back into an array.

---

# Complexity

### Time

```
O(n)
```

Only one pass through the intervals.

---

### Space

```
O(n)
```

For the output list.

---

# Key Takeaway

This problem is much simpler than it first appears.

Every interval must be exactly one of:

```
Before
Overlap
After
```

Recognising those three cases immediately leads to the optimal one-pass solution.

---

# Related Problems

- Merge Intervals
- Non-overlapping Intervals
- Meeting Rooms
- Meeting Rooms II
- Interval List Intersections