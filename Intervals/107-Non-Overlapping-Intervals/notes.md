# Non-overlapping Intervals Notes

## Pattern

Intervals

Greedy

---

# Main Insight

Two overlapping intervals cannot both remain.

Whenever an overlap occurs, one interval **must** be removed.

The important decision is:

```
Which one do we keep?
```

---

# Greedy Choice

Always keep:

```
The interval that finishes first.
```

Why?

Because it leaves the largest possible space for future intervals.

---

# Example

```
[1,10]

[2,3]

[4,5]
```

Keeping:

```
[1,10]
```

prevents adding later intervals.

Keeping:

```
[2,3]
```

allows:

```
[4,5]
```

Therefore:

```
Smaller ending point is always better.
```

---

# Algorithm

Sort by start.

Maintain:

```java
prevEnd
```

representing the end of the last interval we decided to keep.

---

# Case 1

No overlap.

Condition:

```java
currentStart >= prevEnd
```

Update:

```java
prevEnd = currentEnd;
```

---

# Case 2

Overlap.

Condition:

```java
currentStart < prevEnd
```

Remove one interval:

```java
intervalsToRemove++;
```

Keep the earlier finishing interval:

```java
prevEnd = Math.min(prevEnd, currentEnd);
```

---

# Why update prevEnd?

Suppose:

```
prev

[1,8]

current

[2,5]
```

Both overlap.

Instead of remembering:

```
8
```

remember:

```
5
```

because keeping `[2,5]` gives more room for future intervals.

---

# Complexity

Sorting:

```
O(n log n)
```

Traversal:

```
O(n)
```

Overall:

```
O(n log n)
```

Space:

```
O(1)
```

---

# Java Syntax

Sort intervals:

```java
Arrays.sort(intervals,
    (a, b) -> Integer.compare(a[0], b[0]));
```

Keep earlier ending interval:

```java
prevEnd = Math.min(prevEnd, interval[1]);
```

---

# Common Mistakes

### Keeping the interval with the earlier start

Wrong.

The ending value determines how much future space remains.

---

### Merging intervals

This is **not** Merge Intervals.

Here we are deleting intervals, not combining them.

---

### Forgetting to update prevEnd

If you always keep the larger end, the greedy strategy fails.

---

# Interview Explanation

"I sort the intervals by their start time. As I scan through them, I track the end of the last interval I've chosen to keep. Whenever an overlap occurs, I increment the removal count and keep the interval with the smaller ending value because that leaves the most room for future intervals. This greedy choice is optimal."

---

# Pattern Recognition

When you see:

- remove minimum intervals
- maximize intervals kept
- scheduling
- overlap removal

think:

```
Greedy

↓

Keep the interval with the earliest finishing time.
```