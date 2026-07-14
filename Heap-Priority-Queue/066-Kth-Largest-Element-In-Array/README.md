# Kth Largest Element in an Array

## Problem

Given an integer array `nums` and an integer `k`, return the kth largest element in the array.

The kth largest element is the element that would appear at index:

```text id="4d8k2m"
nums.length - k
```

after sorting the array in ascending order.

---

# Example

## Input

```text id="j4n8v2"
nums = [3,2,1,5,6,4]
k = 2
```

## Sorted Array

```text id="c8m1pz"
[1,2,3,4,5,6]
```

The 2nd largest element is:

```text id="f5r9x3"
5
```

## Output

```text id="w7k2q1"
5
```

---

# Approach

## Key Idea

Use a **min heap of size k**.

The heap stores:

> The k largest elements seen so far.

Since it is a min heap:

* The smallest value is always at the root.
* Among the k largest elements, the smallest is the kth largest overall.

Therefore:

```java id="p9w3s7"
pq.peek()
```

returns the answer.

---

# Algorithm

## Step 1: Create Min Heap

Java's default `PriorityQueue` is a min heap:

```java id="k8s4v0"
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

---

## Step 2: Process Each Number

For every number:

```java id="h3m9q6"
pq.offer(num);
```

Add it to the heap.

---

## Step 3: Maintain Heap Size

If the heap contains more than `k` elements:

```java id="v6x2n8"
if(pq.size() > k)
    pq.poll();
```

Remove the smallest element.

This guarantees:

```text id="r2c7m5"
heap contains the k largest numbers
```

---

## Step 4: Return Root

After processing all numbers:

```java id="x4m8z1"
return pq.peek();
```

The smallest value in the heap is the kth largest.

---

# Example Walkthrough

Input:

```text id="n7v2c9"
nums = [3,2,1,5,6,4]
k = 2
```

---

Process:

### Add 3

Heap:

```text id="a6w3p8"
[3]
```

---

### Add 2

Heap:

```text id="m9k1d4"
[2,3]
```

---

### Add 1

Heap:

```text id="t5x7q0"
[1,2,3]
```

Size is greater than `k`.

Remove smallest:

```text id="e2p8s5"
[2,3]
```

---

### Add 5

Heap:

```text id="h4z9n2"
[2,3,5]
```

Remove:

```text id="b7m1x6"
[3,5]
```

---

### Add 6

Heap:

```text id="q8c2v4"
[3,5,6]
```

Remove:

```text id="s5n9j1"
[5,6]
```

---

### Add 4

Heap:

```text id="d3k7p9"
[4,5,6]
```

Remove:

```text id="z6m2w8"
[5,6]
```

Final heap:

```text id="g1v5c3"
[5,6]
```

Answer:

```text id="r4x8n0"
5
```

---

# Complexity Analysis

Let:

```text id="p2m7q8"
n = nums.length
```

---

## Time Complexity

Each insertion:

```text id="w9k3d1"
O(log k)
```

Each removal:

```text id="y5m8v2"
O(log k)
```

For all numbers:

```text id="n3x7c9"
O(n log k)
```

---

## Space Complexity

The heap stores at most `k` elements:

```text id="b6q2m4"
O(k)
```

---

# Alternative Approaches

## Sorting

Sort the entire array:

```java id="j8x4v1"
Arrays.sort(nums);
return nums[nums.length-k];
```

Complexity:

```text id="k7m3q9"
O(n log n)
```

Simple but less efficient.

---

## Quickselect

Quickselect can achieve:

```text id="p8v5c2"
O(n)
```

average time.

However, the heap approach is usually preferred for:

* clarity
* reliability
* Top K pattern recognition

---

# Key Takeaway

When you see:

* kth largest
* kth smallest
* top k elements

consider using a heap.

For kth largest:

```text id="d7m2q8"
Use a min heap of size k
```

For kth smallest:

```text id="x5n9c1"
Use a max heap of size k
```
