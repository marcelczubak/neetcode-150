# Kth Largest Element in a Stream - Notes

## Main Pattern

This problem uses a classic:

> **Top K Elements using a Min Heap**

Pattern.

Whenever you see:

* kth largest
* kth smallest
* top k frequent
* maintain ranking dynamically

think:

```text
Heap
```

---

# Why Min Heap?

A min heap gives:

```text
smallest element at root
```

We exploit this.

For kth largest:

Keep:

```text
k largest elements
```

The smallest among those is the answer.

---

# Heap Invariant

The heap should ALWAYS satisfy:

```text
size <= k
```

Example:

```text
k = 3
```

Current stream:

```text
[10,8,5,2,1]
```

Heap:

```text
[5,8,10]
```

The root:

```text
5
```

is the 3rd largest.

---

# Implementation Steps

## 1. Create Min Heap

Java:

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Default:

* smallest element at root
* `peek()` returns minimum

---

## 2. Add Initial Numbers

For every number:

```java
pq.offer(num);
```

Then maintain size:

```java
while(pq.size() > k)
    pq.poll();
```

---

## 3. Add New Values

When a new number arrives:

```java
pq.offer(val);
```

The heap may now contain:

```text
k + 1
```

elements.

Remove the smallest:

```java
pq.poll();
```

---

## 4. Return Answer

The root is:

```java
pq.peek();
```

because it is the smallest among the k largest values.

---

# Example

```text
k = 2

Numbers:
[3,1,5,2,4]
```

Need the 2nd largest.

After processing:

```text
[4,5]
```

Heap:

```text
[4,5]
```

Answer:

```text
4
```

---

# Common Mistakes

## Using A Max Heap

A max heap stores:

```text
largest at root
```

but we need to remove the smallest values from consideration.

A max heap would require storing everything.

---

## Letting Heap Grow Too Large

Wrong:

```java
for(int num : nums)
    pq.offer(num);
```

Then trim later.

Works, but inefficient.

Better:

```java
for(int num : nums) {

    pq.offer(num);

    if(pq.size() > k)
        pq.poll();
}
```

The heap never exceeds size `k`.

---

## Confusing kth Largest With Index

Example:

```text
[2,3,5,8]
```

3rd largest:

```text
3
```

not:

```text
index 3
```

The heap removes this confusion.

---

# Similar Problems

This pattern appears in:

* Top K Frequent Elements
* K Closest Points to Origin
* Find Median From Data Stream
* Last Stone Weight
* Kth Smallest Element in a Sorted Matrix

---

# Interview Explanation

> "I maintain a min heap containing only the k largest values seen so far. Whenever the heap exceeds size k, I remove the smallest element. This guarantees that the heap root is always the kth largest element. Each insertion costs O(log k) because the heap never contains more than k elements."
