# Reverse Integer Notes

## Pattern

- Math
- Digit Extraction
- Overflow Detection

---

# Core Idea

Reverse the number by repeatedly moving the last digit from the original number onto the end of the result.

Each iteration performs:

```
Extract

↓

Append

↓

Remove
```

---

# Extract Last Digit

```java
digit = x % 10;
```

Example:

```
123

↓

3
```

Negative numbers also work:

```
-123

↓

-3
```

---

# Remove Last Digit

```java
x /= 10;
```

Example:

```
123

↓

12
```

---

# Append Digit

Construct the reversed number:

```java
result = result * 10 + digit;
```

Example:

```
43

+

2

↓

432
```

---

# Overflow Detection

The dangerous operation is:

```java
result * 10
```

Once overflow happens, the value is already corrupted.

Therefore check **before** multiplying.

---

## Maximum Integer

```
2147483647
```

If:

```java
result > MAX / 10
```

overflow is guaranteed.

If:

```java
result == MAX / 10
```

only digits:

```
0–7
```

are safe.

---

## Minimum Integer

```
-2147483648
```

If:

```java
result < MIN / 10
```

overflow occurs.

If:

```java
result == MIN / 10
```

the digit must be at least:

```
-8
```

---

# Why Negative Numbers Work

Using:

```java
while (x != 0)
```

allows both positive and negative integers to be processed.

Java automatically produces:

```text
-123 % 10 = -3

-123 / 10 = -12
```

No call to:

```java
Math.abs()
```

is required.

---

# Helper Function

Separating overflow detection into:

```java
overflow(result, digit)
```

keeps the main loop clean.

Main algorithm:

```
Extract digit

↓

Check overflow

↓

Append digit

↓

Remove digit
```

Each step has a single responsibility.

---

# Common Mistakes

## Checking Overflow Afterwards

Wrong:

```java
result = result * 10 + digit;
```

then checking whether it overflowed.

Overflow has already happened.

Always check first.

---

## Using Math.abs()

Fails for:

```
Integer.MIN_VALUE
```

because:

```
abs(-2147483648)
```

cannot be represented as an `int`.

---

## Using long

The problem explicitly forbids relying on a larger integer type.

Overflow must be handled using only `int`.

---

# Interview Explanation

"I repeatedly extract the last digit using modulo, then append it to the reversed number. Before multiplying the current result by 10, I check whether doing so would exceed the 32-bit integer range. If an overflow would occur, I immediately return 0. Because Java preserves the sign when using modulo and integer division, the same logic naturally handles both positive and negative integers."

---

# Complexity

Time:

```
O(log n)
```

Space:

```
O(1)
```

---

# Key Takeaway

The most important insight is:

```
Overflow must be detected before arithmetic is performed.
```

The digit extraction itself is straightforward—the challenge is ensuring that appending the next digit never exceeds the 32-bit integer limits.