# Target Sum

## Problem

You are given:

- An integer array `nums`
- An integer `target`

Assign either a `'+'` or `'-'` sign to every number.

Return the total number of different expressions whose value equals `target`.

---

## Example

### Input

```text
nums = [1,1,1,1,1]

target = 3
```

### Output

```text
5
```

### Explanation

Five valid expressions:

```text
-1 +1 +1 +1 +1

+1 -1 +1 +1 +1

+1 +1 -1 +1 +1

+1 +1 +1 -1 +1

+1 +1 +1 +1 -1
```

---

## Approach

### DFS + Memoization

For every number, there are exactly two choices:

- Assign a `'+'`
- Assign a `'-'`

This naturally forms a binary recursion tree.

Many recursive branches eventually reach the same state, so memoization is used to avoid recomputation.

---

## Recursive State

Define:

```java
computeSums(target, currentIndex)
```

as:

```text
The number of ways to achieve the remaining target using numbers from currentIndex onwards.
```

Notice that the recursion tracks the **remaining target**, not the current sum.

---

## Key Observation

Suppose we need to achieve:

```text
target = 5
```

and choose:

```text
+2
```

Then the remaining target becomes:

```text
3
```

If instead we choose:

```text
-2
```

the remaining target becomes:

```text
7
```

Rather than accumulating a running sum, the algorithm gradually reduces the remaining target until it reaches zero.

---

## Algorithm

### Step 1

Start recursion:

```java
computeSums(target, 0)
```

---

### Step 2

If this state has already been computed:

```java
cache.containsKey(key)
```

return the cached answer.

---

### Step 3

If every number has been processed:

```java
currentIndex == nums.length
```

Return:

```text
1
```

if:

```text
target == 0
```

Otherwise:

```text
0
```

---

### Step 4

Choose `'+'`

```java
computeSums(target + nums[currentIndex], currentIndex + 1)
```

---

### Step 5

Choose `'-'`

```java
computeSums(target - nums[currentIndex], currentIndex + 1)
```

---

### Step 6

Add both answers together.

Store the result in the cache.

---

## Example Walkthrough

Input:

```text
nums = [1,2]

target = 1
```

Start:

```text
target = 1
```

Choose:

```text
+1
```

Remaining target:

```text
0
```

Choose:

```text
-1
```

Remaining target:

```text
2
```

Each recursive branch continues independently until every number has been assigned a sign.

Whenever:

```text
target == 0
```

after using every number, one valid expression has been found.

---

## Why This Works

Every number contributes exactly one decision:

- positive
- negative

The recursive state is completely determined by:

```text
(currentIndex, remainingTarget)
```

Different recursive paths frequently reach the same state.

Memoization ensures every state is solved only once.

---

## Complexity

Let:

```text
n = nums.length

S = sum of all numbers
```

The remaining target ranges approximately between:

```text
-S ... S
```

There are at most:

```text
n × (2S + 1)
```

unique states.

### Time Complexity

```text
O(n × S)
```

---

### Space Complexity

Memoization:

```text
O(n × S)
```

Recursion stack:

```text
O(n)
```

---

## Pattern Recognition

When you see:

- choose '+' or '-'
- count all possibilities
- repeated recursive states

Think:

```text
DFS

+

Memoization

+

Binary Decision
```

---

## Related Problems

- Partition Equal Subset Sum
- Coin Change II
- Combination Sum
- Climbing Stairs