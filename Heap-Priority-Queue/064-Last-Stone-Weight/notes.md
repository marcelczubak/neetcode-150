# Last Stone Weight - Notes

## Pattern

This problem uses:

> Priority Queue / Heap Simulation

The operation:

```text id="az6j4h"
Repeatedly choose the largest two values
```

immediately suggests a max heap.

---

# Why A Max Heap?

The important operation is:

```text id="j4x9xg"
Find the largest stone quickly
```

A normal array would require:

```text id="mxyjzq"
O(n)
```

search every time.

A max heap gives:

```text id="6m7m2p"
O(log n)
```

removal.

---

# Java PriorityQueue

Java default:

```java id="q6wnr7"
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

is a:

```text id="3e3vcp"
Min Heap
```

Meaning:

```java id="b5tht7"
pq.peek()
```

returns the smallest value.

---

For this problem we need the largest value.

Use:

```java id="3xw2ja"
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

Now:

```java id="1z9d0f"
pq.peek()
```

returns the maximum.

---

# Algorithm Walkthrough

Input:

```text id="w93k1a"
[2,7,4,1,8,1]
```

Create max heap:

```text id="v8px19"
[8,7,4,2,1,1]
```

---

Remove:

```text id="e5mq8r"
8
7
```

Difference:

```text id="2p0s1j"
1
```

Add:

```text id="h1x7d9"
[4,2,1,1,1]
```

---

Remove:

```text id="5py6o1"
4
2
```

Difference:

```text id="3g2b1m"
2
```

Add:

```text id="p3u0d9"
[2,1,1,1]
```

Continue until finished.

---

# Important Observation

The heap is not sorting the stones.

It is maintaining:

> The next largest element can always be removed efficiently.

The internal ordering does not matter.

---

# Common Mistakes

## Using Min Heap

Wrong:

```java id="5h2n4f"
new PriorityQueue<>()
```

This removes the smallest stones first.

The problem requires:

```text id="3br9qx"
largest two stones
```

---

## Sorting Every Round

Possible approach:

```text id="lm3z5t"
sort array
remove largest two
repeat
```

But:

Sorting:

```text id="9t0g0y"
O(n log n)
```

every round is inefficient.

Heap avoids repeated sorting.

---

## Forgetting To Add Difference Back

Example:

```text id="i8f5z7"
10 and 6
```

Remaining stone:

```text id="x8w6az"
4
```

Need:

```java
pq.add(4);
```

---

# Similar Heap Problems

This pattern appears in:

* Kth Largest Element in Stream
* Top K Frequent Elements
* K Closest Points to Origin
* Find Median from Data Stream
* Merge K Sorted Lists

---

# Interview Explanation

> "I use a max heap because I repeatedly need the two heaviest stones. Each round removes the two largest values, calculates the difference if they are different, and inserts the remaining stone back into the heap. Since each heap operation costs O(log n), the total complexity is O(n log n)."
