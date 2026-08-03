# Target Sum Notes

## Pattern

- Dynamic Programming
- DFS
- Memoization

---

# Core Idea

Every number has exactly two choices:

```text
+

or

-
```

This creates a binary recursion tree.

---

# Recursive State

Define:

```java
computeSums(target, index)
```

as:

```text
Number of ways to achieve the remaining target using numbers from index onwards.
```

The DP state consists of:

```text
(index, remainingTarget)
```

---

# Remaining Target

Instead of maintaining:

```text
Current Sum
```

this solution tracks:

```text
Remaining Target
```

Suppose:

```text
Target = 5
```

Choose:

```text
+2
```

Remaining target becomes:

```text
3
```

Choose:

```text
-2
```

Remaining target becomes:

```text
7
```

Eventually:

```text
Remaining Target = 0
```

means a valid expression has been constructed.

---

# DP Recurrence

At every index:

```text
Choose '+'

+

Choose '-'
```

Recurrence:

```java
ways =
compute(target + nums[index], index + 1)

+

compute(target - nums[index], index + 1)
```

The total number of expressions equals the sum of both choices.

---

# Base Case

When:

```java
index == nums.length
```

All numbers have been assigned signs.

If:

```java
target == 0
```

Return:

```text
1
```

One valid expression exists.

Otherwise:

```text
0
```

---

# Memoization

Store:

```java
(target,index)
```

Example key:

```text
"3,5"
```

Before solving:

```java
cache.containsKey(key)
```

return the stored value immediately.

---

# Why Memoization Helps

Without caching:

```text
(index = 5, target = 7)
```

can be reached through many different sign assignments.

Memoization guarantees:

```text
Each state is solved exactly once.
```

---

# Example

Input:

```text
nums = [1,2]

target = 1
```

Choices:

```text
+1

↓

target = 0
```

or

```text
-1

↓

target = 2
```

Each branch independently explores the remaining numbers.

---

# Common Mistakes

## Tracking Current Sum

Many solutions keep:

```text
currentSum
```

instead.

This implementation is equally valid by tracking:

```text
remainingTarget
```

The recurrence simply changes direction.

---

## Forgetting Memoization

Pure recursion explores:

```text
2ⁿ
```

possible assignments.

Many of these reach identical states.

Memoization reduces the complexity dramatically.

---

## Memoizing Only the Target

The same remaining target at different positions represents different subproblems.

Both:

```text
target

and

index
```

must be part of the state.

---

# Interview Explanation

"I treat every number as a binary decision: assign either a plus or minus sign. Instead of tracking the current sum, I track the remaining target that still needs to be achieved. At each recursive call I either subtract or add the current number to this remaining target. Once every number has been processed, a remaining target of zero means a valid expression has been found. Since many recursive branches revisit the same `(index, remainingTarget)` state, I memoize each result to avoid redundant computation."

---

# Complexity

Time:

```text
O(n × S)
```

where:

- `n` = number of elements
- `S` = sum of all numbers

Space:

```text
O(n × S)
```

for the memoization table, plus:

```text
O(n)
```

recursive stack depth.

---

# Key Takeaway

The important insight is defining the recursive state as:

```text
(index, remainingTarget)
```

rather than `(index, currentSum)`.

Every recursive call answers:

```text
"How many ways can I achieve the remaining target using the remaining numbers?"
```

Once this state is identified, the recurrence becomes a simple binary choice:

```text
Choose '+'

or

Choose '-'
```

Memoization transforms the exponential search into an efficient dynamic programming solution by ensuring each unique state is evaluated only once.