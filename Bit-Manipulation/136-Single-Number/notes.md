# Single Number Notes

## Pattern

- Bit Manipulation
- XOR

---

# Core Insight

The XOR operator has a special property:

```
a ^ a = 0
```

Therefore duplicate numbers eliminate themselves.

The remaining value is the answer.

---

# Useful XOR Properties

## Same number

```
a ^ a = 0
```

Example:

```
5 ^ 5 = 0
```

---

## Zero

```
a ^ 0 = a
```

Example:

```
7 ^ 0 = 7
```

---

## Commutative

```
a ^ b = b ^ a
```

Order does not matter.

---

## Associative

```
(a ^ b) ^ c

=

a ^ (b ^ c)
```

Grouping does not matter.

---

# Algorithm

Initialize:

```java
result = 0;
```

For every number:

```java
result ^= num;
```

Return:

```java
result;
```

---

# Example

Input:

```
2 1 4 2 1
```

Process:

```
0 ^ 2 = 2

2 ^ 1 = 3

3 ^ 4 = 7

7 ^ 2 = 5

5 ^ 1 = 4
```

Result:

```
4
```

---

# Why It Works

Rearrange the XOR operations:

```
2 ^ 2 ^ 1 ^ 1 ^ 4
```

Duplicate pairs become:

```
0 ^ 0 ^ 4
```

Then:

```
0 ^ 4 = 4
```

Only the unique element survives.

---

# Common Mistakes

## Using a HashMap

A frequency map works:

```
O(n)
```

time but requires:

```
O(n)
```

space.

The problem specifically asks for constant extra space.

---

## Using Addition/Subtraction

These fail for:

- negative numbers
- overflow
- repeated values

XOR is designed for exactly this cancellation behavior.

---

# Interview Explanation

"I use the XOR operator because XORing a number with itself produces zero, while XORing with zero leaves the number unchanged. Since every duplicated value appears exactly twice, all duplicate pairs cancel each other out during a single pass through the array. The only remaining value is the element that appears once."

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

---

# Key Takeaway

Remember the four XOR properties:

```
a ^ a = 0

a ^ 0 = a

Commutative

Associative
```

These properties make XOR the perfect tool whenever duplicate elements cancel out and exactly one unique value remains.