# Maximum Subarray

## Problem

Given an integer array `nums`, find the contiguous subarray with the largest sum.

Return the maximum sum.

---

## Example

### Input

```
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

### Output

```
6
```

### Explanation

The maximum subarray is:

```
[4,-1,2,1]
```

Sum:

```
4 + (-1) + 2 + 1 = 6
```

---

# Approach

## Kadane's Algorithm

At every index, decide:

1. Extend the existing subarray

```
previous sum + current number
```

OR

2. Start a new subarray

```
current number alone
```

Choose whichever produces the larger sum.

---

## State Definition

`curSum`

Represents:

```
Maximum subarray sum ending at current index
```

Transition:

```
curSum = max(curSum + nums[i], nums[i])
```

---

`maxSum`

Represents:

```
Largest subarray sum found so far
```

Update:

```
maxSum = max(maxSum, curSum)
```

---

# Algorithm

1. Initialise:

```
curSum = nums[0]
maxSum = nums[0]
```

2. Iterate through the array.

3. At each element:
   - Decide whether to extend or restart.
   - Update global maximum.

4. Return `maxSum`.

---

# Complexity

## Time Complexity

```
O(n)
```

Every element is visited once.

---

## Space Complexity

```
O(1)
```

Only constant extra variables are used.

---

# Key Insight

A negative running sum will only hurt future subarrays.

If:

```
curSum + nums[i] < nums[i]
```

then discard the previous subarray and start again.

---

# Pattern Recognition

When you see:

- contiguous subarray
- maximum/minimum sum
- linear scan required

Think:

```
Kadane's Algorithm
```

---

# Related Problems

- Maximum Product Subarray
- Best Time to Buy and Sell Stock
- Maximum Sum Circular Subarray
- Longest Increasing Subsequence