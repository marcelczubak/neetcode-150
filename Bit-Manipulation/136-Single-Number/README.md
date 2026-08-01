# Single Number

## Problem

Given a non-empty array of integers, every element appears **exactly twice** except for one element that appears only once.

Return the element that appears exactly once.

The solution must run in **linear time** and use **constant extra space**.

---

## Example

### Input

```text
nums = [2,2,1]
```

### Output

```text
1
```

---

### Input

```text
nums = [4,1,2,1,2]
```

### Output

```text
4
```

---

# Approach

## Bit Manipulation (XOR)

The XOR operator (`^`) has several useful properties:

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

XOR is commutative.

```
(a ^ b) ^ c = a ^ (b ^ c)
```

XOR is associative.

These properties allow every duplicated number to cancel itself, leaving only the unique element.

---

# Algorithm

1. Initialize:

```java
int result = 0;
```

2. XOR every number into the result.

```java
result ^= num;
```

3. Every duplicated value cancels out.

4. Return the remaining value.

---

# Example Walkthrough

Input:

```text
[4,1,2,1,2]
```

Start:

```
result = 0
```

After XOR with 4:

```
0 ^ 4 = 4
```

After XOR with 1:

```
4 ^ 1 = 5
```

After XOR with 2:

```
5 ^ 2 = 7
```

After XOR with another 1:

```
7 ^ 1 = 6
```

After XOR with another 2:

```
6 ^ 2 = 4
```

All duplicate numbers cancel.

Final answer:

```
4
```

---

# Why This Works

Every duplicated number appears exactly twice.

Because:

```
a ^ a = 0
```

each duplicate pair disappears.

Since XOR is associative and commutative, the order does not matter.

Only the unique element remains.

---

# Complexity

Let:

```
n = number of elements
```

## Time Complexity

One pass through the array.

```
O(n)
```

---

## Space Complexity

Only one integer variable is used.

```
O(1)
```

---

# Pattern Recognition

When you see:

- every element appears twice
- one unique element
- constant space required

Think:

```
Bit Manipulation

+

XOR
```

---

# Related Problems

- Missing Number
- Find the Duplicate Number
- Single Number II
- Single Number III
- Counting Bits