# Non-overlapping Intervals

## Problem

Given an array of intervals:

```
intervals[i] = [start, end]
```

return the **minimum number of intervals to remove** so that the remaining intervals are non-overlapping.

---

## Example 1

### Input

```text
intervals = [[1,2],[2,3],[3,4],[1,3]]
```

### Output

```text
1
```

### Explanation

Remove:

```text
[1,3]
```

Remaining:

```text
[1,2]
[2,3]
[3,4]
```

No overlaps remain.

---

## Example 2

### Input

```text
intervals = [[1,2],[1,2],[1,2]]
```

### Output

```text
2
```

Only one interval can remain.

---

# Key Observation

This is **not** a merge problem.

Instead, every time two intervals overlap, one of them **must be removed**.

The question becomes:

> Which interval should we keep?

The optimal greedy choice is:

> **Keep the interval that finishes first.**

Keeping the earlier finishing interval leaves the most room for future intervals.

---

# Approach

## Step 1

Sort intervals by their start value.

```java
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
```

---

## Step 2

Assume the first interval is kept.

Store its ending value.

```text
prevEnd
```

---

## Step 3

Process every remaining interval.

There are only two cases.

---

### Case 1 — No overlap

```
currentStart >= prevEnd
```

Example:

```text
[1,2]

      [3,5]
```

Safe to keep both.

Update:

```text
prevEnd = currentEnd
```

---

### Case 2 — Overlap

```
currentStart < prevEnd
```

Example:

```text
[1,4]

   [2,3]
```

One interval must be removed.

Increment:

```text
intervalsToRemove++
```

Then keep the interval with the **smaller end**.

```java
prevEnd = Math.min(prevEnd, currentEnd);
```

---

# Why keep the smaller end?

Example:

```text
[1,10]

[2,3]

[4,5]
```

If we keep:

```
[1,10]
```

everything afterwards overlaps.

If we keep:

```
[2,3]
```

we can also keep:

```
[4,5]
```

Keeping the earlier ending interval always leaves more space.

---

# Algorithm

1. Sort intervals by start.
2. Store the first interval's end.
3. Iterate through remaining intervals.
4. If no overlap:
   - Update `prevEnd`.
5. Otherwise:
   - Remove one interval.
   - Keep the interval with the smaller end.
6. Return the number removed.

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

---

Space:

```
O(1)
```

Only a few variables are used.

---

# Key Takeaway

Whenever two intervals overlap:

```
Keep the interval that ends first.
```

This greedy choice guarantees the maximum space for future intervals and therefore minimizes removals.

---

# Related Problems

- Merge Intervals
- Insert Interval
- Meeting Rooms
- Meeting Rooms II
- Interval List Intersections