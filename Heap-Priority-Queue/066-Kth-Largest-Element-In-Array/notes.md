# Kth Largest Element in an Array - Notes

## Pattern

This is a classic:

> Top K Elements using Heap

problem.

The key question:

> How can we avoid sorting the entire array?

Answer:

Maintain only the information we need.

---

# Heap Invariant

The most important idea:

```text id="y8m3q2"
The heap always contains the k largest elements seen so far.
```

Example:

```text id="c5v9x1"
k = 3
```

Numbers:

```text id="g4n8m6"
[5,1,9,2,7]
```

After processing:

```text id="h7p2d4"
heap = [5,7,9]
```

The smallest element:

```text id="m2x6q8"
5
```

is the 3rd largest.

---

# Why Min Heap?

A min heap keeps the smallest element at the root.

For kth largest:

We want to remove values that are too small.

Example:

```text id="q9v3c5"
k = 2
```

Heap:

```text id="w4m7x2"
[5,10]
```

New value:

```text id="n6p1z8"
12
```

Temporary:

```text id="a3k8m5"
[5,10,12]
```

Too many elements.

Remove:

```java id="j5q9v1"
poll()
```

Removes:

```text id="b7x2m4"
5
```

Remaining:

```text id="c8n4p6"
[10,12]
```

These are the 2 largest.

---

# Why Not Max Heap?

A max heap stores the largest value at the root.

That is useful for:

```text id="x6m1q9"
repeatedly getting maximum
```

but here we need to discard the smallest values.

A max heap would require storing all `n` elements.

---

# Implementation Steps

## 1. Create Heap

```java id="v4k8s2"
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```

---

## 2. Add Every Number

```java id="z7m3p1"
for(int num : nums)
{
    minHeap.offer(num);
}
```

---

## 3. Remove Extra Elements

Maintain:

```text id="h5n2c8"
heap size <= k
```

Code:

```java id="r9v6m3"
if(minHeap.size() > k)
    minHeap.poll();
```

---

## 4. Return Answer

The root is the kth largest:

```java id="t2x8q5"
return minHeap.peek();
```

---

# Common Mistakes

## Mistake 1: Keeping the k smallest values

Wrong invariant:

```text id="g8m2v6"
heap contains smallest k
```

Correct:

```text id="p4x9n1"
heap contains largest k
```

---

## Mistake 2: Using k as an index

Example:

```text id="z3q7m8"
[1,2,3,4,5]
k = 2
```

Answer:

```text id="c6v1x9"
4
```

not:

```text id="a8m5p2"
index 2
```

---

## Mistake 3: Forgetting the Heap Size Limit

Without:

```java id="d7n3q6"
if(pq.size() > k)
    pq.poll();
```

the heap becomes:

```text id="m9x2c5"
O(n)
```

and loses the efficiency advantage.

---

# Related Problems

This exact pattern appears in:

* Kth Largest Element in a Stream
* K Closest Points to Origin
* Top K Frequent Elements
* Find Median From Data Stream
* Merge K Sorted Lists

---

# Interview Explanation

> "I maintain a min heap of size k. The heap contains the k largest elements encountered so far. When adding a new number causes the heap to exceed size k, I remove the smallest element. This ensures the root of the heap is always the kth largest element. The solution runs in O(n log k) time and O(k) space."
