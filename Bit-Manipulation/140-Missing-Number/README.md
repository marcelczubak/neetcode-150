# Missing Number

## Problem

Given an array `nums` containing `n` distinct numbers in the range:

```text
[0, n]
```

exactly one number is missing.

Return the missing number.

The solution should run in **linear time** and use **constant extra space**.

---

## Example

### Input

```text
nums = [3,0,1]
```

### Output

```text
2
```

---

### Input

```text
nums = [0,1]
```

### Output

```text
2
```

---

### Input

```text
nums = [9,6,4,2,3,5,7,0,1]
```

### Output

```text
8
```

---

# Approach

## XOR Cancellation

The key observation is that every number except the missing one appears **twice**:

- Once in the expected range `0...n`
- Once in the input array

The missing number appears only once.

Using the properties of XOR, every duplicate pair cancels itself, leaving only the missing value.

---

# XOR Properties

```
a ^ a = 0
```

A number XOR itself cancels out.

```
a ^ 0 = a
```

Zero is the identity element.

```
a ^ b = b ^ a
```

Order does not matter.

```
(a ^ b) ^ c = a ^ (b ^ c)
```

Grouping does not matter.

---

# Algorithm

### Step 1

Initialize:

```java
int result = nums.length;
```

Why?

The loop iterates over indices:

```text
0 ... n-1
```

so the value `n` must be included manually.

---

### Step 2

For every index:

```java
result ^= i;
```

XOR the expected value.

---

### Step 3

XOR the actual array value.

```java
result ^= nums[i];
```

---

### Step 4

After the loop, every duplicated number has cancelled itself.

The remaining value is the missing number.

---

# Example Walkthrough

Input:

```text
nums = [3,0,1]
```

Start:

```text
result = 3
```

Loop:

```
result ^= 0

result ^= 3
```

```
result ^= 1

result ^= 0
```

```
result ^= 2

result ^= 1
```

Every duplicated value disappears.

Remaining:

```text
2
```

---

# Why This Works

The expected sequence is:

```text
0 ^ 1 ^ 2 ^ ... ^ n
```

The array contributes:

```text
nums[0] ^ nums[1] ^ ...
```

Every value that appears in both sequences cancels out.

Only the missing value remains.

---

# Complexity

Let:

```text
n = nums.length
```

## Time Complexity

One pass through the array.

```text
O(n)
```

---

## Space Complexity

Only one integer variable is used.

```text
O(1)
```

---

# Pattern Recognition

When you see:

- one missing element
- numbers from `0...n`
- constant space required

Think:

```text
Bit Manipulation

+

XOR Cancellation
```

---

# Related Problems

- Single Number
- Find the Duplicate Number
- Missing Ranges
- Counting Bits