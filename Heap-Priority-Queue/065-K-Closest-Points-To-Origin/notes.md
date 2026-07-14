# K Closest Points to Origin - Notes

## Pattern

This problem uses:

> Top K Elements with Heap

The question:

> "Find the k closest points"

means:

Do not sort everything.

Instead:

Maintain only the best `k` candidates.

---

# Heap Choice

The most important decision:

## Need k smallest distances

Therefore:

Keep a:

```text id="r8k4x2"
Max Heap
```

Why?

Because when we have too many points:

```text id="7m2p5q"
k + 1 points
```

we need to remove:

```text id="a4v8m1"
the farthest point
```

A max heap gives the farthest point instantly.

---

# Example

k = 2

Points:

```text id="x7m3b8"
A distance = 3
B distance = 8
C distance = 12
```

Heap:

```text id="9s2q6a"
[12,8]
```

New point:

```text id="d5p0v1"
distance = 5
```

Heap:

```text id="c9x4w2"
[12,8,5]
```

Too large.

Remove:

```java id="e3r7z0"
poll()
```

Removes:

```text id="v1k6n8"
12
```

Remaining:

```text id="m5q2h9"
[8,5]
```

These are the two closest points.

---

# Distance Calculation

Do not use:

```java id="q5s9d1"
Math.sqrt()
```

The actual distance is:

```text id="f8w2m4"
sqrt(x²+y²)
```

But comparing:

```text id="z0n4k7"
sqrt(a) < sqrt(b)
```

is equivalent to:

```text id="p3x7c2"
a < b
```

So use:

```java id="h7m1s8"
x*x + y*y
```

It is faster and avoids unnecessary floating point operations.

---

# Comparator Breakdown

The heap stores:

```java id="6b3z9q"
new int[] {
    distance,
    x,
    y
}
```

Comparator:

```java id="m8q4s1"
(a,b) -> Integer.compare(b[0], a[0])
```

means:

Compare using distance.

Reverse order:

```text id="x2c7v9"
largest distance first
```

Therefore:

```java id="q9m5d2"
pq.peek()
```

is always the farthest point among the current candidates.

---

# Common Mistakes

## Using Min Heap

Wrong:

```java id="h3k9q7"
new PriorityQueue<>()
```

This keeps the smallest element at the root.

But we need to remove the largest distance.

---

## Sorting All Points

Possible:

```java id="n7b2x4"
Arrays.sort(points)
```

Complexity:

```text id="m1v8p3"
O(n log n)
```

The heap approach:

```text id="q6z4s0"
O(n log k)
```

is better when:

```text id="k << n
```

---

## Calculating Actual Distance

Avoid:

```java id="p0w3r8"
Math.sqrt()
```

Use:

```java id="t4n7m2"
x*x + y*y
```

---

# Interview Explanation

> "I use a max heap of size k because I need to keep the k smallest distances. The heap stores the current closest candidates, and the largest distance is kept at the root. Whenever the heap exceeds size k, I remove the farthest point. This gives O(n log k) time and O(k) space."
