# Maximum Product Subarray

## Problem

Given an integer array `nums`, find the contiguous subarray that has the largest product and return its product.

---

## Example

### Input

```
nums = [2,3,-2,4]
```

### Output

```
6
```

Explanation:

```
[2,3] has the maximum product:

2 * 3 = 6
```

---

# Approach

This problem is similar to **Kadane's Algorithm**, but multiplication introduces an important complication.

For sums:

```
negative numbers usually decrease the result
```

For products:

```
negative × negative = positive
```

A very small negative product can become the largest product later.

Therefore, at every index we track:

1. The maximum product ending at this index.
2. The minimum product ending at this index.

---

# Dynamic Programming State

Maintain:

```
currentMax
```

The maximum product subarray ending at the current index.

```
currentMin
```

The minimum product subarray ending at the current index.

The minimum is required because:

```
negative × negative = positive
```

---

# State Transition

For each number:

There are three possible ways to form a product:

1. Start a new subarray:

```
nums[i]
```

2. Extend the previous maximum:

```
currentMax * nums[i]
```

3. Extend the previous minimum:

```
currentMin * nums[i]
```

The new maximum is:

```
max(
    nums[i],
    previousMax * nums[i],
    previousMin * nums[i]
)
```

The new minimum is:

```
min(
    nums[i],
    previousMax * nums[i],
    previousMin * nums[i]
)
```

---

# Why Track Minimum?

Example:

```
nums = [-2,3,-4]
```

After processing:

```
[-2,3]
```

we have:

```
currentMax = 3
currentMin = -6
```

When multiplying by:

```
-4
```

the minimum becomes:

```
-6 * -4 = 24
```

Without storing the minimum, we would miss the optimal answer.

---

# Algorithm

1. Initialize:

```
currentMax = nums[0]
currentMin = nums[0]
result = nums[0]
```

2. Iterate through the array.

3. For each number:
    - Calculate new maximum product.
    - Calculate new minimum product.
    - Update global result.

4. Return result.

---

# Complexity

## Time Complexity

```
O(n)
```

Each element is processed once.

---

## Space Complexity

```
O(1)
```

Only three variables are stored.

---

# Pattern Recognition

When you see:

- Maximum/minimum subarray
- Contiguous elements
- Dynamic programming
- Negative numbers affecting future values

Think:

```
Track both maximum and minimum states
```

---

# Related Problems

- Maximum Subarray
- Best Time to Buy and Sell Stock
- House Robber
- Coin Change
- Decode Ways