# Kth Largest Element in a Stream

## Problem

Design a data structure that finds the kth largest element in a stream of numbers.

The class should support:

* Initialising with an array of numbers.
* Adding new numbers dynamically.
* Returning the kth largest value after each insertion.

---

## Example

### Input

```text
k = 3

nums = [4,5,8,2]

add(3)
add(5)
add(10)
add(9)
add(4)
```

### Output

```text
4
5
5
8
8
```

---

# Approach

## Key Idea

Use a **min heap** (`PriorityQueue`) of size `k`.

The heap stores:

> The k largest elements seen so far.

Since it is a min heap:

* The smallest element among these k values is at the root.
* That root is the kth largest element overall.

---

# Example Walkthrough

Given:

```text
k = 3
```

Stream:

```text
[4,5,8,2]
```

Maintain a heap containing the 3 largest values.

Insert:

```text
4
```

Heap:

```text
[4]
```

---

Insert:

```text
5
```

Heap:

```text
[4,5]
```

---

Insert:

```text
8
```

Heap:

```text
[4,5,8]
```

The smallest value:

```text
4
```

is the 3rd largest.

---

Insert:

```text
2
```

Heap temporarily:

```text
[2,4,5,8]
```

Size exceeds `k`, so remove the smallest:

```java
pq.poll();
```

Heap becomes:

```text
[4,5,8]
```

---

# Algorithm

## Constructor

1. Store `k`.
2. Add every number into the min heap.
3. Remove elements while heap size exceeds `k`.

---

## add()

When a new value arrives:

1. Insert it into the heap.

```java
pq.offer(val);
```

2. If heap size exceeds `k`:

   * Remove the smallest element.

```java
pq.poll();
```

3. Return:

```java
pq.peek();
```

The root is always the kth largest value.

---

# Why A Min Heap?

A max heap would store all values and require removing the largest values.

Instead, we only care about the top `k` largest numbers.

A min heap naturally removes the smallest among those `k` values.

Example:

```text
All numbers:

[1,2,3,4,5,6]

k = 3
```

Keep:

```text
[4,5,6]
```

The smallest value in this group:

```text
4
```

is the 3rd largest.

---

# Complexity Analysis

Let:

* `n` = number of initial values
* `k` = kth largest position

---

## Constructor

Building heap:

```text
O(n log k)
```

because we maintain heap size `k`.

---

## add()

Each insertion:

```text
O(log k)
```

The heap never exceeds size `k`.

---

## Space

```text
O(k)
```

Only the k largest values are stored.

---

# Key Takeaway

The important invariant:

> The heap always contains exactly the k largest elements seen so far.

Therefore:

```java
pq.peek()
```

always gives:

> The kth largest element.
