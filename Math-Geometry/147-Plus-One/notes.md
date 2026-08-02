# Plus One Notes

## Pattern

- Simulation
- Array Traversal
- Carry Propagation

---

# Core Idea

Perform the same process used when adding numbers by hand.

Starting from the last digit:

```
Increment

↓

Carry if necessary

↓

Stop when carry disappears
```

---

# Traverse Backwards

The least significant digit is at the end.

Process:

```java
for (int i = digits.length - 1; i >= 0; i--)
```

---

# No Carry

If:

```java
digits[i] < 9
```

Simply:

```java
digits[i]++;
```

The addition is complete.

Return immediately.

Example:

```text
128

↓

129
```

---

# Carry

If:

```java
digits[i] == 9
```

Then:

```java
digits[i] = 0;
```

Carry moves to the next digit.

Example:

```text
199

↓

190

↓

200
```

---

# All Digits Were 9

Example:

```text
999
```

Every digit becomes:

```text
000
```

The carry extends beyond the array.

Allocate:

```java
int[] result = new int[digits.length + 1];
```

Set:

```java
result[0] = 1;
```

Final answer:

```text
1000
```

---

# Example

Input:

```text
[4,5,9]
```

Process:

```text
9

↓

0
```

Carry.

Next digit:

```text
5

↓

6
```

Carry stops.

Answer:

```text
[4,6,0]
```

---

# Why Early Return Works

Once a digit smaller than `9` is incremented:

```
Carry disappears.
```

No earlier digits are affected.

Therefore the algorithm can immediately return.

---

# Common Mistakes

## Traversing Left to Right

Addition starts with the least significant digit.

Always process from right to left.

---

## Forgetting the All-9 Case

Example:

```text
999
```

needs:

```text
1000
```

The array must grow by one element.

---

## Continuing After Carry Ends

Once:

```java
digits[i]++
```

has been performed on a digit less than `9`, the work is finished.

Return immediately.

---

# Interview Explanation

"I simulate manual addition starting from the least significant digit. If a digit is less than 9, I increment it and return immediately because the carry is resolved. If the digit is 9, it becomes 0 and the carry propagates to the next position. If every digit is 9, the carry extends beyond the most significant digit, so I allocate a new array one element longer with a leading 1."

---

# Complexity

Time:

```
O(n)
```

Worst case when every digit is `9`.

Space:

```
O(1)
```

Extra working space.

A new array of size `n + 1` is only created when required for the returned result.

---

# Key Takeaway

The important observation is that **carry propagation only continues through consecutive trailing `9`s**.

As soon as a digit smaller than `9` is found:

```text
Increment

↓

Carry disappears

↓

Return immediately
```

This makes the algorithm both simple and efficient.