# Merge Intervals Notes

## Pattern

Intervals

Common interview pattern:

```
Sort → Scan → Merge
```

---

# Main Insight

Intervals are initially unordered.

Sorting by starting point guarantees that:

```
every possible overlap
```

must occur with the **most recently merged interval**.

---

# Why sort?

Without sorting:

```
[5,7]

[1,3]

[2,6]
```

You don't know which intervals should merge.

After sorting:

```
[1,3]

[2,6]

[5,7]
```

You can process left to right.

---

# Core Logic

Maintain:

```
result
```

whose final interval is always the latest merged interval.

For every interval:

```
current
```

compare against:

```
latest
```

---

# Case 1 — Overlap

Condition

```java
currentStart <= latestEnd
```

Example

```
latest

[1,5]

current

     [3,8]
```

Merge

```java
latest[1] =
    Math.max(latest[1], currentEnd);
```

Notice that the start never changes because the intervals are sorted.

---

# Case 2 — No Overlap

Condition

```java
currentStart > latestEnd
```

Example

```
latest

[1,4]

current

         [7,9]
```

Action

```java
result.add(current);
```

---

# Why only compare with the last interval?

Suppose we've already merged:

```
[1,10]
```

Any earlier interval is already inside this merged interval.

Therefore:

```
Only the last interval can possibly overlap.
```

---

# Complexity

Sorting

```
O(n log n)
```

Traversal

```
O(n)
```

Overall

```
O(n log n)
```

Space

```
O(n)
```

---

# Java Syntax

Sort by first element

```java
Arrays.sort(intervals,
    (a, b) -> Integer.compare(a[0], b[0]));
```

Get last element

```java
int[] latest =
    result.get(result.size() - 1);
```

Extend merged interval

```java
latest[1] =
    Math.max(latest[1], currentEnd);
```

---

# Common Mistakes

## Forgetting to sort

Without sorting, comparing only the last interval is incorrect.

---

## Comparing every interval

A nested loop gives:

```
O(n²)
```

Sorting removes the need for this.

---

## Updating the start

Only update:

```java
latest[1]
```

The start remains the smallest because intervals are processed in ascending order.

---

# Interview Explanation

"I first sort the intervals by their start time. Then I maintain a list of merged intervals. For each new interval, I compare it only with the most recently merged interval. If they overlap, I extend the end of the merged interval. Otherwise, I add the current interval as a new disjoint interval."

---

# Pattern Recognition

Whenever you see:

- merge intervals
- overlapping ranges
- meeting rooms
- interval scheduling

think:

```
Sort first.
Then scan once.
```

This is one of the most common interval interview patterns.