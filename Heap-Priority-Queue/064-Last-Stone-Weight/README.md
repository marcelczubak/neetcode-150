# Last Stone Weight

## Problem

You are given an array of stones where:

* Each stone has a positive integer weight.
* Each turn, choose the two heaviest stones and smash them together.

Rules:

* If both stones have the same weight, both are destroyed.
* If they have different weights, the heavier stone remains with weight:

```text
heavier - lighter
```

Return the weight of the final remaining stone.

If no stones remain, return `0`.

---

# Example

## Input

```text id="l7a3m4"
stones = [2,7,4,1,8,1]
```

## Process

Choose:

```text id="cxn4n0"
8 and 7
```

Result:

```text id="v6r0xm"
1
```

Remaining:

```text id="j4m2y6"
[2,4,1,1,1]
```

Choose:

```text id="9f1x1b"
4 and 2
```

Result:

```text id="o9l1ka"
2
```

Continue until one stone remains.

---

## Output

```text id="4d9h5q"
1
```

---

# Approach

## Key Idea

Always choose the **two largest stones**.

The best data structure for repeatedly retrieving the maximum value is a:

```text id="4h2j2r"
Max Heap
```

Java's `PriorityQueue` is a min heap by default, so we reverse the ordering:

```java
PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());
```

---

# Algorithm

## Step 1: Create Max Heap

Insert all stones:

```java
for(int stone : stones)
    pq.add(stone);
```

The largest stone is always accessible using:

```java
pq.remove();
```

---

## Step 2: Smash Stones

While there are at least two stones:

```java
while(pq.size() >= 2)
```

Remove the two heaviest:

```java
int stoneA = pq.remove();
int stoneB = pq.remove();
```

---

## Step 3: Compare Weights

### Equal weights

Example:

```text id="p9u8la"
5 and 5
```

Both disappear.

Do nothing.

---

### Different weights

Example:

```text id="m0y7hq"
8 and 3
```

Remaining stone:

```text id="s2k5h4"
8 - 3 = 5
```

Add it back:

```java
pq.add(stoneA - stoneB);
```

---

## Step 4: Return Result

After smashing:

* No stones remain → return `0`
* One stone remains → return its weight

```java
return pq.size() == 0 ? 0 : pq.peek();
```

---

# Complexity Analysis

Let:

```text id="j09k3p"
n = number of stones
```

---

## Heap Construction

Adding all stones:

```text id="yz6v1m"
O(n log n)
```

---

## Smashing Process

Each smash:

* Removes 2 stones.
* Adds at most 1 stone.

There are at most `n` operations.

Each heap operation:

```text id="brs3hj"
O(log n)
```

Total:

```text id="cz9f5g"
O(n log n)
```

---

## Space Complexity

The heap stores all stones:

```text id="8wq7zp"
O(n)
```

---

# Key Takeaway

When a problem repeatedly asks:

> "Give me the largest/smallest element and remove it"

think:

```text id="i1lh3m"
Heap / Priority Queue
```

This problem is a classic **Max Heap simulation** problem.
