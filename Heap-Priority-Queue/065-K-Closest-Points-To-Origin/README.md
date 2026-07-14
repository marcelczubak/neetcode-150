# K Closest Points to Origin

## Problem

Given an array of points on a 2D plane:

```text id="x8qf3a"
[x, y]
```

return the `k` points closest to the origin:

```text id="4s9x1a"
(0,0)
```

The distance between a point and the origin is:

```text id="k2j7p8"
x² + y²
```

The answer can be returned in any order.

---

# Example

## Input

```text id="b7z9q1"
points =
[
 [1,3],
 [-2,2]
]

k = 1
```

## Distances

Point:

```text id="g1b3s8"
[1,3]
```

Distance:

```text id="5u0p3x"
1² + 3² = 10
```

---

Point:

```text id="1q9v6r"
[-2,2]
```

Distance:

```text id="j8h4x0"
(-2)² + 2² = 8
```

---

Closest point:

```text id="3g7f9x"
[-2,2]
```

## Output

```text id="m6c9d1"
[[-2,2]]
```

---

# Approach

## Key Idea

Use a **max heap of size k**.

The heap stores:

> The k closest points seen so far.

However, because we need to remove the farthest point whenever we exceed `k`, we use a max heap.

The largest distance is always at the top.

---

# Why A Max Heap?

Example:

```text id="f2k8v3"
k = 3
```

Current closest points:

```text
[
 [1,1], distance 2
 [2,2], distance 8
 [3,3], distance 18
]
```

Heap:

```text id="t5s1q8"
largest distance at root
```

If a new point arrives:

```text id="z7q0b2"
distance = 20
```

The heap becomes size 4.

Remove:

```java id="3h5q9m"
pq.poll();
```

which removes the farthest point.

The heap returns to containing only the 3 closest points.

---

# Algorithm

## Step 1: Create Max Heap

Java's `PriorityQueue` is a min heap by default.

We reverse the comparator:

```java id="9z8w4r"
PriorityQueue<int[]> pq =
    new PriorityQueue<>(
        (a,b) -> Integer.compare(b[0], a[0])
    );
```

The first element stores the distance.

Example:

```java id="h1g5p0"
[
 distance,
 x,
 y
]
```

---

## Step 2: Process Points

For every point:

Calculate squared distance:

```java id="p7k2z6"
distance = x*x + y*y;
```

No need to calculate:

```text id="r8h3w1"
sqrt(distance)
```

because square root does not change ordering.

---

Store:

```java id="m8x0s4"
[
 distance,
 x,
 y
]
```

in the heap.

---

## Step 3: Maintain Heap Size

If:

```java id="c8v1m2"
pq.size() > k
```

remove the largest distance:

```java id="d4q9y0"
pq.poll();
```

The heap now contains the k closest points.

---

## Step 4: Build Result

Extract remaining points from the heap.

The heap stores:

```text id="n7g3k2"
[distance, x, y]
```

but output requires:

```text id="b1v5z8"
[x,y]
```

so copy:

```java id="z6t0p2"
result[i][0] = point[1];
result[i][1] = point[2];
```

---

# Complexity Analysis

Let:

```text id="k4w9n6"
n = number of points
k = number of closest points required
```

---

## Time Complexity

Each point:

* Insert into heap: `O(log k)`
* Possible removal: `O(log k)`

For `n` points:

```text id="q3s8d1"
O(n log k)
```

---

## Space Complexity

Heap stores at most `k` points:

```text id="m9x2v7"
O(k)
```

Result storage:

```text id="c4h8y1"
O(k)
```

Total:

```text id="p6z3w0"
O(k)
```

---

# Key Takeaway

When a problem asks for:

* k closest
* k largest
* k smallest
* top k elements

think:

```text id="h8s2q4"
Heap of size k
```

For:

* kth largest → min heap
* kth smallest → max heap
* k closest → max heap (remove farthest)
