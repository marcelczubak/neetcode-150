# Maximum Product Subarray Notes

## Pattern

Dynamic Programming

Variation of:

```
Kadane's Algorithm
```

---

# Core Insight

For maximum sum:

```
only track maximum
```

because a smaller sum is always worse.

For multiplication:

```
track maximum AND minimum
```

because:

```
negative × negative = positive
```

A bad value now can become the best value later.

---

# DP State

At every index:

```
currentMax
```

=

maximum product ending at this index.

```
currentMin
```

=

minimum product ending at this index.

---

# Transition

For each number:

Candidates:

```
nums[i]
```

Start new subarray.

```
currentMax * nums[i]
```

Extend previous maximum.

```
currentMin * nums[i]
```

Extend previous minimum.

---

New maximum:

```
max(
 nums[i],
 previousMax * nums[i],
 previousMin * nums[i]
)
```

---

New minimum:

```
min(
 nums[i],
 previousMax * nums[i],
 previousMin * nums[i]
)
```

---

# Example

Input:

```
[-2,3,-4]
```

Start:

```
max = -2
min = -2
result = -2
```

Process 3:

Candidates:

```
3
-6
-6
```

Update:

```
max = 3
min = -6
```

---

Process -4:

Candidates:

```
-4
-12
24
```

Update:

```
max = 24
min = -12
```

Answer:

```
24
```

---

# Implementation Notes

Important:

Always use the previous maximum and minimum values.

Example:

```java
int prevMax = currentMax;
int prevMin = currentMin;
```

Then calculate the new states.

This avoids accidentally overwriting values needed for the transition.

---

# Common Mistakes

## Only tracking maximum

Wrong:

```
currentMax only
```

because negative products can become positive later.

---

## Resetting at negative values

Unlike maximum sum subarray:

```
negative != always bad
```

A negative product may be valuable.

---

## Forgetting single element subarrays

The answer may simply be:

```
[-5]
```

so always consider:

```
nums[i]
```

as a candidate.

---

# Interview Explanation

"I use a dynamic programming approach similar to Kadane's algorithm. Because multiplication behaves differently with negative numbers, I maintain both the maximum and minimum product ending at each position. The minimum is important because multiplying two negatives can create the largest product. At each index I calculate the three possible products and update the maximum, minimum, and global result."

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```