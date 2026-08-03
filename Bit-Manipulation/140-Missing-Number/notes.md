# Missing Number Notes

## Pattern

- Bit Manipulation
- XOR

---

# Core Idea

Every number should appear twice:

- Once in the expected range.
- Once in the array.

The missing number appears only once.

XOR automatically removes every duplicate.

---

# XOR Properties

Duplicate numbers cancel:

```text
a ^ a = 0
```

Zero changes nothing:

```text
a ^ 0 = a
```

Order does not matter:

```text
a ^ b = b ^ a
```

Grouping does not matter:

```text
(a ^ b) ^ c = a ^ (b ^ c)
```

---

# Why Start With n?

The loop visits indices:

```text
0

↓

n - 1
```

The value:

```text
n
```

never appears as an index.

Initialize:

```java
int result = nums.length;
```

so every number in:

```text
0...n
```

is included exactly once.

---

# Algorithm

Initialize:

```java
result = nums.length;
```

For every index:

```java
result ^= i;
```

Then XOR the array value:

```java
result ^= nums[i];
```

Return:

```java
result;
```

---

# Example

Input:

```text
nums = [3,0,1]
```

Expected numbers:

```text
0 1 2 3
```

Array:

```text
3 0 1
```

Combined XOR:

```text
0 ^ 1 ^ 2 ^ 3 ^ 3 ^ 0 ^ 1
```

Cancel duplicates:

```text
2
```

Answer:

```text
2
```

---

# Why It Works

Every value except the missing number appears twice.

XOR eliminates every duplicate automatically.

The only remaining value is the missing number.

---

# Common Mistakes

## Forgetting n

Many solutions start with:

```java
int result = 0;
```

and only XOR:

```java
0...n-1
```

The value:

```text
n
```

is never included.

Initializing with:

```java
nums.length
```

fixes this.

---

## Using a HashSet

A set works:

```text
O(n)
```

time but requires:

```text
O(n)
```

space.

XOR achieves constant extra space.

---

## Using the Sum Formula

Another solution uses:

```text
n(n + 1) / 2
```

and subtracts the array sum.

While also `O(n)`, it can overflow for very large values unless a larger integer type is used.

XOR avoids this issue entirely.

---

# Interview Explanation

"I XOR every expected number from `0` to `n` together with every value in the input array. Since XORing a number with itself produces zero, every value that appears in both sequences cancels out. The only value that does not have a matching pair is the missing number, so it remains after all XOR operations."

---

# Complexity

Time:

```text
O(n)
```

Space:

```text
O(1)
```

---

# Alternative Solution

A mathematical approach computes:

```text
Expected Sum = n(n + 1) / 2
```

Then subtracts the actual array sum.

Result:

```text
Expected Sum - Actual Sum
```

This also runs in:

```text
O(n)
```

but XOR is generally preferred because it avoids overflow and uses elegant bit manipulation.

---

# Key Takeaway

The important insight is:

```text
Expected Numbers

XOR

Actual Numbers
```

Every duplicate value disappears because:

```text
a ^ a = 0
```

leaving only the missing number. This makes XOR one of the cleanest constant-space solutions to missing element problems.