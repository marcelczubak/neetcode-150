README.md

# Find Median From Data Stream

## Problem

Design a data structure that supports:

- Adding numbers from a data stream.
- Finding the current median efficiently.

The median is:

- The middle value when numbers are sorted.
- The average of the two middle values when there are an even number of elements.

---

# Approach

## Two Heap Solution

Instead of sorting the entire list after every insertion, maintain two halves of the numbers.

```
Smaller Half | Larger Half
```

Use:

- A max heap for the smaller half.
- A min heap for the larger half.

The median will always be found at the top of these heaps.

---

# Data Structures

## Max Heap

Stores the smaller half of numbers.

Example:

```
Numbers:
1 2 3

maxHeap:
3
2 1
```

The top element:

```
maxHeap.peek()
```

represents the largest value in the smaller half.

---

## Min Heap

Stores the larger half of numbers.

Example:

```
Numbers:
4 5 6

minHeap:
4
5 6
```

The top element:

```
minHeap.peek()
```

represents the smallest value in the larger half.

---

# Algorithm

## addNum()

When inserting a new number:

1. Decide which heap it belongs to.
2. Insert into the heap.
3. Balance the heaps if necessary.

Maintain:

```
maxHeap = smaller half

minHeap = larger half
```

---

## Choosing The Heap

Compare the number with:

```
maxHeap.peek()
```

because this is the boundary between the two halves.

If the number belongs to the larger half:

```
add to minHeap
```

Otherwise:

```
add to maxHeap
```

---

## Balancing

The heaps must always satisfy:

```
|maxHeap.size() - minHeap.size()| <= 1
```

If one heap has too many elements:

Move the root element to the other heap.

Example:

Before:

```
maxHeap:

1 2 3 4


minHeap:

8
```

Move:

```
4
```

to minHeap.

After:

```
maxHeap:

1 2 3


minHeap:

4 8
```

---

# Finding Median

## Odd Number Of Elements

One heap contains one extra element.

Return:

```
maxHeap.peek()
```

Example:

```
1 2 3 4 5

maxHeap:
1 2 3

minHeap:
4 5
```

Median:

```
3
```

---

## Even Number Of Elements

Both heaps have equal size.

Median:

```
(maxHeap.peek() + minHeap.peek()) / 2.0
```

Example:

```
1 2 3 4
```

Median:

```
(2 + 3) / 2 = 2.5
```

---

# Complexity Analysis

Let:

```
n = number of inserted elements
```

## addNum()

Heap insertion:

```
O(log n)
```

Balancing:

```
O(log n)
```

Total:

```
O(log n)
```

---

## findMedian()

Only accessing heap roots:

```
O(1)
```

---

## Space

Both heaps store every number:

```
O(n)
```

---

# Common Mistakes

## poll() vs peek()

Wrong:

```
heap.poll()
```

because it removes the element.

Correct:

```
heap.peek()
```

because we only need to inspect the median.

---

## Integer Division

Wrong:

```
(a + b) / 2
```

Java performs integer division.

Example:

```
5 / 2 = 2
```

Correct:

```
(a + b) / 2.0
```

Result:

```
2.5
```

---

# Pattern Recognition

When you see:

- A stream of numbers.
- Need the median after each insertion.

Think:

```
Two Heaps
```

Mental model:

```
             Median

       maxHeap | minHeap

       smaller | larger
        half   | half
```

---

notes.md

# Find Median From Data Stream - Notes

## Pattern

Two Heaps

The goal is to maintain a sorted stream without actually sorting the entire collection.

Split numbers into two halves:

```
Smaller Half | Larger Half
```

Maintain:

- Max heap -> smaller half
- Min heap -> larger half

---

# Max Heap

Stores the smaller half.

Why max heap?

Because we need quick access to the largest number in the smaller half.

Example:

```
1 2 3
```

Max heap:

```
3
2 1
```

Access:

```
maxHeap.peek()
```

---

# Min Heap

Stores the larger half.

Why min heap?

Because we need quick access to the smallest number in the larger half.

Example:

```
4 5 6
```

Min heap:

```
4
5 6
```

Access:

```
minHeap.peek()
```

---

# addNum()

Steps:

1. Insert number into correct heap.
2. Balance heaps.

---

# Heap Decision

The boundary is:

```
maxHeap.peek()
```

Rules:

```
If num > maxHeap.peek():

    minHeap.offer(num)

Else:

    maxHeap.offer(num)
```

The max heap always contains the smaller values.

The min heap always contains the larger values.

---

# Balancing

After insertion:

```
|maxHeap.size() - minHeap.size()| <= 1
```

must always be true.

If one heap grows too large:

Move its root to the other heap.

Example:

Before:

```
maxHeap:
1 2 3 4

minHeap:
8
```

Move:

```
4
```

After:

```
maxHeap:
1 2 3

minHeap:
4 8
```

---

# findMedian()

## Odd Count

One heap has one extra element.

Return:

```
maxHeap.peek()
```

---

## Even Count

Both heaps are equal.

Return:

```
(maxHeap.peek() + minHeap.peek()) / 2.0
```

Important:

Use `2.0` to avoid integer division.

---

# Common Errors

## Using poll()

Wrong:

```
heap.poll()
```

This removes the median.

Use:

```
heap.peek()
```

to only read the value.

---

## Integer Division

Wrong:

```
5 / 2 = 2
```

Correct:

```
5 / 2.0 = 2.5
```

---

# Complexity

## addNum()

```
O(log n)
```

because heap insertion and balancing take logarithmic time.

---

## findMedian()

```
O(1)
```

Only reads heap roots.

---

## Space

```
O(n)
```

All inserted values are stored.

---

# Key Insight

This problem is a dynamic version of finding the middle element.

Instead of sorting:

```
[1,2,3,4,5]
```

every time, maintain:

```
        Median

maxHeap | minHeap

small   | large
half    | half
```

The two heap tops are always the median candidates.

Pattern:

```
Incoming number
        |
        v
Choose heap
        |
        v
Balance heaps
        |
        v
Read median
```