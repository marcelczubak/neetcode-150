# Minimum Interval to Include Each Query Notes

## Pattern

Intervals

Sorting

Sweep Line

Priority Queue

Offline Queries

---

# Main Idea

For each query:

Find:

```
smallest interval containing query
```

Condition:

```
start <= query <= end
```

---

# Why Not Brute Force?

Brute force:

For every query:

```
check every interval
```

Complexity:

```
O(n*m)
```

Too slow.

---

# Offline Query Technique

Instead of answering queries in the original order:

```
[5,2,3]
```

process them sorted:

```
[2,3,5]
```

This allows us to move through intervals once.

---

# Maintaining Original Query Order

Queries can repeat:

Example:

```
[3,3,5]
```

A HashMap does not work:

```
3 -> index 0
3 -> index 1  overwrites
```

Use:

```
[value, originalIndex]
```

Example:

```
[
 [3,0],
 [3,1],
 [5,2]
]
```

After sorting, the index is still preserved.

---

# Sweep Line

Maintain pointer:

```java
int intervalIndex;
```

This tracks the next interval to consider.

For every query:

Add intervals:

```java
interval.start <= query
```

because they have become possible candidates.

---

# Min Heap

Heap contains:

```
intervals that started but have not expired
```

Sorted by:

```
interval length
```

Example:

```
[1,10] -> length 10

[2,5]  -> length 4
```

Heap top:

```
[2,5]
```

---

# Removing Invalid Intervals

An interval is useless when:

```java
interval.end < query
```

Example:

Query:

```
8
```

Interval:

```
[1,5]
```

Cannot contain query.

Remove:

```java
heap.poll();
```

---

# Heap Comparator

Intervals:

```java
int[] interval
```

where:

```
interval[0] = start
interval[1] = end
```

Comparator:

```java
(a,b) -> 
Integer.compare(
    a[1]-a[0],
    b[1]-b[0]
)
```

The `+1` is not required for ordering:

```
(end-start)
```

and

```
(end-start+1)
```

produce the same ordering.

---

# Java PriorityQueue

Create:

```java
PriorityQueue<int[]> heap =
    new PriorityQueue<>(
        (a,b) -> Integer.compare(
            a[1]-a[0],
            b[1]-b[0]
        )
    );
```

Add:

```java
heap.add(interval);
```

Smallest:

```java
heap.peek();
```

Remove:

```java
heap.poll();
```

---

# Algorithm Template

```
Sort intervals by start

Sort queries with original indices

Create min heap

For each query:

    Add intervals that started

    Remove intervals that ended

    If heap not empty:
        answer = heap.peek length
    Else:
        answer = -1
```

---

# Interview Explanation

"I sort the intervals and queries so I can process them from left to right. While iterating through queries, I add all intervals that have started and remove intervals that have already ended. A min heap ordered by interval size lets me always retrieve the smallest valid interval for the current query."

---

# Recognition Pattern

When you see:

- multiple queries
- intervals
- need best/smallest/largest matching interval

Think:

```
Offline queries

+

Sweep line

+

Heap
```