# Minimum Interval to Include Each Query

## Problem

Given a list of intervals:

```
[start, end]
```

and a list of queries, return the length of the **smallest interval** that contains each query.

A query `q` is contained in an interval if:

```
start <= q <= end
```

If no interval contains the query, return:

```
-1
```

---

## Example

### Input

```text
intervals = [[1,4],[2,4],[3,6],[4,4]]
queries = [2,3,5]
```

### Output

```text
[3,3,4]
```

### Explanation

Query `2`:

```
[1,4]  length = 4
[2,4]  length = 3  ✅ smallest
```

Answer:

```
3
```

---

Query `3`:

```
[1,4] length = 4
[2,4] length = 3  ✅
[3,6] length = 4
```

Answer:

```
3
```

---

Query `5`:

```
[3,6]
```

Answer:

```
4
```

---

# Key Observation

Checking every interval for every query would be:

```
O(n * m)
```

where:

- `n` = number of intervals
- `m` = number of queries

This is too slow.

Instead, process intervals and queries together using:

```
Sorting + Sweep Line + Min Heap
```

---

# Approach

## Step 1 — Sort Intervals

Sort intervals by their starting value.

Example:

Before:

```
[3,6]
[1,4]
[2,4]
```

After:

```
[1,4]
[2,4]
[3,6]
```

This allows us to add intervals as queries increase.

---

## Step 2 — Sort Queries with Original Indices

Queries need to be processed in increasing order.

However, we must return answers in the original order.

Store:

```
[query value, original index]
```

Example:

Original:

```
queries = [5,2,3]
```

Stored:

```
[
 [5,0],
 [2,1],
 [3,2]
]
```

Sorted:

```
[
 [2,1],
 [3,2],
 [5,0]
]
```

The index lets us place answers correctly.

---

## Step 3 — Maintain Min Heap

The heap stores intervals that could answer the current query.

Priority:

```
smallest interval length
```

Example:

```
[1,10] length 10

[3,5] length 3
```

Heap keeps:

```
[3,5]
```

at the top.

---

## Step 4 — Process Each Query

For every query:

### Add valid starting intervals

Any interval where:

```
interval.start <= query
```

could potentially contain the query.

Add it to the heap.

---

### Remove expired intervals

Remove intervals where:

```
interval.end < query
```

because they cannot contain the query anymore.

---

### Heap Top

After removing invalid intervals:

```
heap.peek()
```

is the smallest valid interval.

Store:

```
end - start + 1
```

If heap is empty:

```
-1
```

---

# Algorithm

1. Sort intervals by start.
2. Store queries with their original indices.
3. Sort queries.
4. Create a min heap ordered by interval size.
5. Sweep through queries:
   - Add intervals that have started.
   - Remove intervals that have ended.
   - Use heap top as answer.
6. Return answers in original query order.

---

# Complexity

Let:

```
n = number of intervals
m = number of queries
```

Sorting intervals:

```
O(n log n)
```

Sorting queries:

```
O(m log m)
```

Each interval is added and removed from heap once:

```
O(n log n)
```

Overall:

```
O((n + m) log n)
```

---

Space:

```
O(n + m)
```

For:

- heap
- sorted query storage
- output array

---

# Key Takeaway

This is an **offline query problem**.

Instead of answering queries independently:

```
query -> search all intervals
```

sort everything and sweep once:

```
sort intervals
sort queries
process left to right
use heap for best candidate
```

---

# Related Problems

- Meeting Rooms II
- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Car Pooling
- K Closest Points