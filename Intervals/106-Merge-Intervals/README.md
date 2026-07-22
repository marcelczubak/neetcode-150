# Merge Intervals

## Problem

Given an array of intervals where:

```
intervals[i] = [start, end]
```

merge all overlapping intervals and return a list of non-overlapping intervals covering the same ranges.

The intervals are **not guaranteed to be sorted**.

---

## Example 1

### Input

```text
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

### Output

```text
[[1,6],[8,10],[15,18]]
```

### Explanation

```
[1,3]
   [2,6]
```

These overlap, so they merge into:

```
[1,6]
```

---

## Example 2

### Input

```text
intervals = [[1,4],[4,5]]
```

### Output

```text
[[1,5]]
```

Intervals touching at an endpoint are considered overlapping.

---

# Key Observation

Merging is only easy if intervals are processed in **ascending order of their start time**.

Therefore, the first step is:

```java
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
```

Once sorted, every new interval only needs to be compared against the **most recently merged interval**.

---

# Approach

## Step 1

Sort intervals by their starting value.

Example:

```
Before:

[5,7]
[1,3]
[2,6]

↓

After sorting

[1,3]
[2,6]
[5,7]
```

---

## Step 2

Create an output list.

Initially:

```
result = [ first interval ]
```

---

## Step 3

For every remaining interval:

Compare it against the **last interval in the result**.

```
latest
```

There are only two cases.

---

### Case 1 — Overlap

```
currentStart <= latestEnd
```

Example:

```
latest

[1,5]

current

    [4,8]
```

Merge by extending the end:

```java
latest[1] = Math.max(latest[1], currentEnd);
```

---

### Case 2 — No Overlap

```
currentStart > latestEnd
```

Example:

```
latest

[1,3]

current

          [7,10]
```

Simply add the interval.

---

# Algorithm

1. Sort intervals by start.
2. Add the first interval to the result.
3. Iterate through the remaining intervals.
4. Compare with the last merged interval.
5. If overlapping:
   - Extend the end.
6. Otherwise:
   - Add the interval.
7. Convert the list back into an array.

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
O(n)
```

for the output list.

---

# Key Takeaway

After sorting, the problem becomes extremely simple.

Each interval only needs to be compared with:

```
the last merged interval
```

not every previous interval.

---

# Related Problems

- Insert Interval
- Meeting Rooms
- Meeting Rooms II
- Non-overlapping Intervals
- Interval List Intersections